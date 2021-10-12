package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "burger_menu")
public class BurgerRestaurantMenu {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "burger_restaurant_id")
    private BurgerRestaurant burgerRestaurant;
    private String name;
    private String description;

    public BurgerRestaurantMenu(String id, BurgerRestaurant burgerRestaurant, String name, String description) {
        this.id = id;
        this.burgerRestaurant = burgerRestaurant;
        this.name = name;
        this.description = description;
    }
}
