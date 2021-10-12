package com.example.demo.service;

import com.example.demo.domain.BurgerRestaurant;
import com.example.demo.domain.User;
import com.example.demo.repository.BurgerRestaurantRepository;
import com.example.demo.service.nearbyresturants.HaversineStrategy;
import com.example.demo.service.nearbyresturants.NearbyRestaurantStrategy;
import com.example.demo.service.nearbyresturants.RandomRestaurantStrategy;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional //todo laver alt i din transaction læs op: tradition bank eksempel
public class BurgerRestaurantService {
    private final BurgerRestaurantRepository burgerRestaurantRepository;
    private final UserService userService;

    public BurgerRestaurantService(BurgerRestaurantRepository burgerRestaurantRepository, UserService userService) {
        this.burgerRestaurantRepository = burgerRestaurantRepository;
        this.userService = userService;
    }

    public void createBurgerRestaurant(BurgerRestaurant burgerRestaurant) {
        burgerRestaurantRepository.save(burgerRestaurant);
    }

    public List<BurgerRestaurant> findNearbyRestaurants(String userId) {
        List<BurgerRestaurant> restaurants = burgerRestaurantRepository.findAll();
        User user = userService.getUser(userId);
        NearbyRestaurantStrategy nearbyRestaurantStrategy;
        if (user.isPremiumMember()) {
            nearbyRestaurantStrategy = new HaversineStrategy();
        } else {
            nearbyRestaurantStrategy = new RandomRestaurantStrategy();
        }
        return nearbyRestaurantStrategy.findNearbyRestaurantStrategy(restaurants);
    }
}
