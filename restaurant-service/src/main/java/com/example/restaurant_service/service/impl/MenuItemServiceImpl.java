package com.example.restaurant_service.service.impl;

import com.example.restaurant_service.dto.MenuItemDto;
import com.example.restaurant_service.model.MenuItem;
import com.example.restaurant_service.repository.MenuItemRepository;
import com.example.restaurant_service.repository.RestaurantRepository;
import com.example.restaurant_service.service.MenuItemService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restaurant_service.model.Restaurant;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public MenuItemDto createMenuItem(MenuItemDto dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        MenuItem item = new MenuItem();
        item.setRestaurant(restaurant);
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());

        MenuItem saved = menuItemRepository.save(item);

        dto.setId(saved.getId());
        return dto;
    }



    @Override
    public MenuItemDto getMenuItemById(Long id) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        return new MenuItemDto(item.getId(), item.getRestaurant().getId(), item.getName(), item.getPrice());
    }


    @Override
    public List<MenuItemDto> getMenuItemsByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId).stream()
                .map(item -> new MenuItemDto(item.getId(), item.getRestaurant().getId(), item.getName(), item.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public MenuItemDto updateMenuItem(Long id, MenuItemDto dto) {
        MenuItem item = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        item.setName(dto.getName());
        item.setPrice(dto.getPrice());

        menuItemRepository.save(item);
        dto.setId(id);
        return dto;
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}

