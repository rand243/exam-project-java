package com.example.restaurant_service.service.impl;

import com.example.restaurant_service.dto.MenuItemDto;
import com.example.restaurant_service.dto.RestaurantDto;
import com.example.restaurant_service.model.Restaurant;
import com.example.restaurant_service.repository.RestaurantRepository;
import com.example.restaurant_service.service.MenuItemService;
import com.example.restaurant_service.service.RestaurantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemService menuItemService;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, MenuItemService menuItemService) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemService = menuItemService;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDto.getName());
        restaurant.setLocation(restaurantDto.getLocation());
        restaurant.setRating(restaurantDto.getRating());

        Restaurant saved = restaurantRepository.save(restaurant);
        restaurantDto.setId(saved.getId());
        return restaurantDto;
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Optional<Restaurant> optional = restaurantRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Restaurant not found with id: " + id);
        }
        Restaurant restaurant = optional.get();
        List<MenuItemDto> menuItems = menuItemService.getMenuItemsByRestaurantId(id);
        return new RestaurantDto(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getLocation(),
                restaurant.getRating(),
                menuItems
        );
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(r -> new RestaurantDto(
                        r.getId(),
                        r.getName(),
                        r.getLocation(),
                        r.getRating(),
                        menuItemService.getMenuItemsByRestaurantId(r.getId())
                )).collect(Collectors.toList());
    }

    @Override
    public RestaurantDto updateRestaurant(Long id, RestaurantDto dto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        restaurant.setName(dto.getName());
        restaurant.setLocation(dto.getLocation());
        restaurant.setRating(dto.getRating());

        restaurantRepository.save(restaurant);
        dto.setId(id);
        return dto;
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}

