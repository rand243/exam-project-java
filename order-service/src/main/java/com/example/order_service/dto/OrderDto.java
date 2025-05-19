package com.example.order_service.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {

    private Long orderId;
    private Long userId;
    private Long restaurantId;
    private Double totalPrice;
    private String orderStatus;
    private LocalDateTime createdAt;
    private String customerName;
    private String items;
    private Double totalAmount;
    private List<OrderDetailDto> orderDetails;

    public OrderDto() {}

    public OrderDto(Long orderId, Long userId, Long restaurantId, Double totalPrice, String orderStatus,
                    LocalDateTime createdAt, String customerName, String items, Double totalAmount,
                    List<OrderDetailDto> orderDetails) {
        this.orderId = orderId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderDetailDto> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDto> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
