package com.example.demo.service;

import com.example.demo.domain.BurgerRestaurant;
import com.example.demo.domain.User;
import com.example.demo.repository.BurgerRestaurantRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerRestaurantServiceTest {

    @Mock
    private BurgerRestaurantRepository burgerRestaurantRepository;
    @Mock
    private UserService userService;

    @Test
    public void testFindNearbyRestaurantsHaversineStrategy() {
        BurgerRestaurantService burgerRestaurantService = new BurgerRestaurantService(burgerRestaurantRepository, userService);
        //given
        String randomID = "randomId";
        boolean hasHaversineStrategy = true;
        //when
        when(burgerRestaurantRepository.findAll()).thenReturn(new ArrayList<>());
        when(userService.getUser(randomID)).thenReturn(new User(randomID, hasHaversineStrategy));
        List<BurgerRestaurant> result = burgerRestaurantService.findNearbyRestaurants(randomID);
        //then
        Assertions.assertNotNull(result.get(0));
        Assertions.assertEquals("08.00", result.get(0).getRestaurantOpeningHours().get(0).getStartTime());
        Assertions.assertEquals("Burger king", result.get(0).getName());
        Assertions.assertEquals(10.00, result.get(0).getLatitude());
    }

    @Test
    public void testFindNearbyRestaurantsRandomRestaurantStrategy() {
        BurgerRestaurantService burgerRestaurantService = new BurgerRestaurantService(burgerRestaurantRepository, userService);
        //given
        String randomID = "randomId";
        boolean hasHaversineStrategy = false;
        //when
        when(burgerRestaurantRepository.findAll()).thenReturn(new ArrayList<>());
        when(userService.getUser(randomID)).thenReturn(new User(randomID, hasHaversineStrategy));
        List<BurgerRestaurant> result = burgerRestaurantService.findNearbyRestaurants(randomID);
        //then
        Assertions.assertNotNull(result.get(0));
        Assertions.assertEquals("09.00", result.get(0).getRestaurantOpeningHours().get(1).getStartTime());
        Assertions.assertEquals("Faraway burger join", result.get(0).getName());
        Assertions.assertEquals(42.00, result.get(0).getLatitude());
    }

}
