package com.example.order_service.dto;

public class OrderDetailDto {

    private Long orderDetailId;
    private Long orderId;
    private Long menuItemId;
    private Integer quantity;

    public OrderDetailDto() {}

    public OrderDetailDto(Long orderDetailId, Long orderId, Long menuItemId, Integer quantity) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.menuItemId = menuItemId;
        this.quantity = quantity;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

