package com.example.demo.service.nearbyresturants;

import com.example.demo.domain.BurgerRestaurant;
import com.example.demo.domain.BurgerRestaurantMenu;
import com.example.demo.domain.RestaurantOpeningHours;
import com.example.demo.domain.Weekdays;

import java.util.ArrayList;
import java.util.List;

public class RandomRestaurantStrategy implements NearbyRestaurantStrategy {
    private static final String FAKE_BURGER_ID = "someFakeIdForBurger2";
    private static final String FAKE_BURGER_MENU_ID = "fakeMenu2";
    private static final String FAKE_OPENING_HOUR = "09.00";
    private static final String FAKE_CLOSING_HOUR = "21.00";

    @Override
    public List<BurgerRestaurant> findNearbyRestaurantStrategy(List<BurgerRestaurant> burgerRestaurants) {
        List<BurgerRestaurant> result = new ArrayList<>();
        result.add(createFarAwayRestaurant(burgerRestaurants));
        return result;
    }

    private BurgerRestaurant createFarAwayRestaurant(List<BurgerRestaurant> burgerRestaurants) {
        return new BurgerRestaurant("someFakeIdForBurger2", "Faraway burger join", 42.00, 42.00, 1, createFakeBurgerMenu(), createFakeOpeningHours());
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
        RestaurantOpeningHours monday = new RestaurantOpeningHours("mondayId2", restaurant, Weekdays.MONDAY, null, null);
        RestaurantOpeningHours tuesday = new RestaurantOpeningHours("tuesdayId2", restaurant, Weekdays.TUESDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours wednesday = new RestaurantOpeningHours("wednesdayId2", restaurant, Weekdays.WEDNESDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours thursday = new RestaurantOpeningHours("thursdayId2", restaurant, Weekdays.THURSDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours friday = new RestaurantOpeningHours("fridayId2", restaurant, Weekdays.FRIDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours saturday = new RestaurantOpeningHours("saturdayId2", restaurant, Weekdays.SATURDAY, FAKE_OPENING_HOUR, FAKE_CLOSING_HOUR);
        RestaurantOpeningHours sunday = new RestaurantOpeningHours("sundayId2", restaurant, Weekdays.SUNDAY, null, null);
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
