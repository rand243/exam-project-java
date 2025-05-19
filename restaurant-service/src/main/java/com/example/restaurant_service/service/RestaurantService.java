package com.example.restaurant_service.service;


import com.example.restaurant_service.dto.RestaurantDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);
    RestaurantDto getRestaurantById(Long id);
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto updateRestaurant(Long id, RestaurantDto restaurantDto);
    void deleteRestaurant(Long id);
}

