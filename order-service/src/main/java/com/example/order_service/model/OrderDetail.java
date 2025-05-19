package com.example.order_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details", schema = "food_delivery")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailId;

    private Long menuItemId;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetail() {}

    // Getters and setters

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}


