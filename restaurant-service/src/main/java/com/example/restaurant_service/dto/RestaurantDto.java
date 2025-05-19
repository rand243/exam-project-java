package com.example.restaurant_service.dto;

import java.util.List;

public class RestaurantDto {
    private Long id;
    private String name;
    private String location;
    private Double rating;
    private List<MenuItemDto> menuItems;

    public RestaurantDto() {}

    public RestaurantDto(Long id, String name, String location, Double rating, List<MenuItemDto> menuItems) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.menuItems = menuItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<MenuItemDto> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDto> menuItems) {
        this.menuItems = menuItems;
    }
}

