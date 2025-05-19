package com.example.order_service.service;

import com.example.order_service.dto.OrderDto;
import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    List<OrderDto> getAllOrders();
    List<OrderDto> getOrdersByUserId(Long userId);
    List<OrderDto> getOrdersByRestaurantId(Long restaurantId);
    void deleteOrder(Long id);
}

