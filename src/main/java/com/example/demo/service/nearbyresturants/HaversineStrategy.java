package com.example.demo.service.nearbyresturants;

import com.example.demo.domain.BurgerRestaurant;
import com.example.demo.domain.BurgerRestaurantMenu;
import com.example.demo.domain.RestaurantOpeningHours;
import com.example.demo.domain.Weekdays;

import java.util.ArrayList;
import java.util.List;

public class HaversineStrategy implements NearbyRestaurantStrategy {
    private static final String FAKE_BURGER_ID = "someFakeIdForBurger";
    private static final String FAKE_BURGER_MENU_ID = "fakeMenu1";
    private static final String FAKE_OPENING_HOUR = "08.00";
    private static final String FAKE_CLOSING_HOUR = "22.00";

    @Override
    public List<BurgerRestaurant> findNearbyRestaurantStrategy(List<BurgerRestaurant> burgerRestaurants) {
        return filterRestaurants(burgerRestaurants);
    }

    private List<BurgerRestaurant> filterRestaurants(List<BurgerRestaurant> burgerRestaurants) {
        List<BurgerRestaurant> result = new ArrayList<>();
        result.add(createFakeBurger());
        return result;
    }

    private BurgerRestaurant createFakeBurger() {
        return new BurgerRestaurant(FAKE_BURGER_ID, "Burger king", 10.00, 10.00, 7, createFakeBurgerMenu(), createFakeOpeningHours());
    }

    private List<BurgerRestaurantMenu> createFakeBurgerMenu() {
        List<BurgerRestaurantMenu> result = new ArrayList<>();
        BurgerRestaurant restaurant = new BurgerRestaurant(FAKE_BURGER_ID);
        BurgerRestaurantMenu menu = new BurgerRestaurantMenu(FAKE_BURGER_MENU_ID, restaurant, "cheeseburger", "with cheese");
        result.add(menu);
        return result;
    }

    private List<RestaurantOpeningHours> createFakeOpeningHours() {
        List<RestaurantOpeningHours> result = new ArrayList<>();
        BurgerRestaurant restaurant = new BurgerRestaurant(FAKE_BURGER_ID);
        RestaurantOpeningHours monday = new RestaurantOpeningHours("mondayId1", restaurant, Weekdays.MONDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours tuesday = new RestaurantOpeningHours("tuesdayId1", restaurant, Weekdays.TUESDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours wednesday = new RestaurantOpeningHours("wednesdayId1", restaurant, Weekdays.WEDNESDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours thursday = new RestaurantOpeningHours("thursdayId1", restaurant, Weekdays.THURSDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours friday = new RestaurantOpeningHours("fridayId1", restaurant, Weekdays.FRIDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours saturday = new RestaurantOpeningHours("saturdayId1", restaurant, Weekdays.SATURDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours sunday = new RestaurantOpeningHours("sundayId1", restaurant, Weekdays.SUNDAY, null, null);
        result.add(monday);
        result.add(tuesday);
        result.add(wednesday);
        result.add(thursday);
        result.add(friday);
        result.add(saturday);
        result.add(sunday);

        return result;
    }
}
