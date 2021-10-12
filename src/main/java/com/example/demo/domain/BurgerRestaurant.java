package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "burger_restaurant")
public class BurgerRestaurant {
    @Id
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private double score;
    @OneToMany
    @JoinColumn(name = "burger_menu_id")
    private List<BurgerRestaurantMenu> burgerMenus;
    @OneToMany
    @JoinColumn(name = "burger_opening_hours_id")
    private List<RestaurantOpeningHours> restaurantOpeningHours;

    public BurgerRestaurant() {
    }

    public BurgerRestaurant(String id) {
        this.id = id;
    }

    public BurgerRestaurant(String id, String name, double latitude, double longitude, double score, List<BurgerRestaurantMenu> burgerMenus, List<RestaurantOpeningHours> restaurantOpeningHours) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.score = score;
        this.burgerMenus = burgerMenus;
        this.restaurantOpeningHours = restaurantOpeningHours;
    }
}
