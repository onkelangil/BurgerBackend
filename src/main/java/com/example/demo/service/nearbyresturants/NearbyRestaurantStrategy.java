package com.example.demo.service.nearbyresturants;

import com.example.demo.domain.BurgerRestaurant;

import java.util.List;

public interface NearbyRestaurantStrategy {
    List<BurgerRestaurant> findNearbyRestaurantStrategy(List<BurgerRestaurant> burgerRestaurants);
}
