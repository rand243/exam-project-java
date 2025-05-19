package com.example.restaurant_service.service;

import com.example.restaurant_service.dto.MenuItemDto;

import java.util.List;

public interface MenuItemService {
    MenuItemDto createMenuItem(MenuItemDto menuItemDto);
    MenuItemDto getMenuItemById(Long id);
    List<MenuItemDto> getMenuItemsByRestaurantId(Long restaurantId);
    MenuItemDto updateMenuItem(Long id, MenuItemDto menuItemDto);
    void deleteMenuItem(Long id);
}

