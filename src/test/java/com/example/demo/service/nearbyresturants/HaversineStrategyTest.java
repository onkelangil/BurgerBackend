package com.example.demo.service.nearbyresturants;

import com.example.demo.domain.BurgerRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HaversineStrategyTest {
    private NearbyRestaurantStrategy strategy = new HaversineStrategy();

    @Test
    public void testHaversineStrategy() {
        //given
        List<BurgerRestaurant> burgerRestaurantList = new ArrayList<>();
        //when
        List<BurgerRestaurant> result = strategy.findNearbyRestaurantStrategy(burgerRestaurantList);
        //then
        Assertions.assertNotNull(result.get(0));
        Assertions.assertEquals("22.00", result.get(0).getRestaurantOpeningHours().get(0).getEndTime());
        Assertions.assertEquals("someFakeIdForBurger", result.get(0).getId());
        Assertions.assertEquals(7, result.get(0).getScore());
    }
}
