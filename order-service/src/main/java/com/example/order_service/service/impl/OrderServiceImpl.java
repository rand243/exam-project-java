package com.example.order_service.service.impl;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.dto.OrderDetailDto;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderDetail;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.repository.OrderDetailRepository;
import com.example.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto dto) {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setRestaurantId(dto.getRestaurantId());
        order.setTotalPrice(dto.getTotalPrice());
        order.setOrderStatus(dto.getOrderStatus());
        order.setCustomerName(dto.getCustomerName());
        order.setItems(dto.getItems());
        order.setTotalAmount(dto.getTotalAmount());

        Order savedOrder = orderRepository.save(order);

        List<OrderDetail> details = dto.getOrderDetails().stream().map(d -> {
            OrderDetail detail = new OrderDetail();
            detail.setOrder(savedOrder);
            detail.setMenuItemId(d.getMenuItemId());
            detail.setQuantity(d.getQuantity());
            return detail;
        }).collect(Collectors.toList());

        orderDetailRepository.saveAll(details);

        dto.setOrderId(savedOrder.getOrderId());
        return dto;
    }

    @Override
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        List<OrderDetail> details = orderDetailRepository.findByOrderOrderId(id);

        List<OrderDetailDto> detailDtos = details.stream().map(d -> {
            OrderDetailDto dto = new OrderDetailDto();
            dto.setOrderDetailId(d.getOrderDetailId());
            dto.setMenuItemId(d.getMenuItemId());
            dto.setQuantity(d.getQuantity());
            return dto;
        }).collect(Collectors.toList());

        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setUserId(order.getUserId());
        dto.setRestaurantId(order.getRestaurantId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setOrderStatus(order.getOrderStatus());
        dto.setCustomerName(order.getCustomerName());
        dto.setItems(order.getItems());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setOrderDetails(detailDtos);

        return dto;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> getOrderById(order.getOrderId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(order -> getOrderById(order.getOrderId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByRestaurantId(Long restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId).stream()
                .map(order -> getOrderById(order.getOrderId()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderDetailRepository.findByOrderOrderId(id).forEach(orderDetailRepository::delete);
        orderRepository.deleteById(id);
    }
}

