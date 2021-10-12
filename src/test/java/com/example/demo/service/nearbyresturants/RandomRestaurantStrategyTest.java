package com.example.demo.service.nearbyresturants;

import com.example.demo.domain.BurgerRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomRestaurantStrategyTest {

    private NearbyRestaurantStrategy strategy = new RandomRestaurantStrategy();

    @Test
    public void testHaversineStrategy() {
        //given
        List<BurgerRestaurant> burgerRestaurantList = new ArrayList<>();
        //when
        List<BurgerRestaurant> result = strategy.findNearbyRestaurantStrategy(burgerRestaurantList);
        //then
        Assertions.assertNotNull(result.get(0));
        Assertions.assertEquals("21.00", result.get(0).getRestaurantOpeningHours().get(1).getEndTime());
        Assertions.assertEquals("someFakeIdForBurger2", result.get(0).getId());
        Assertions.assertEquals(45.00, result.get(0).getLongitude());
        Assertions.assertEquals(1, result.get(0).getScore());
    }
}
