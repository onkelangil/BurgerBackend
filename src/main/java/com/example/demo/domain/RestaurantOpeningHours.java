package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "burger_opening_hours")
public class RestaurantOpeningHours {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "burger_restaurant_id")
    private BurgerRestaurant burgerRestaurant;
    @Type(type = "org.hibernate.type.TextType")
    private Weekdays weekday;
    private String startTime;
    private String endTime;

    public RestaurantOpeningHours(String id, BurgerRestaurant burgerRestaurantId, Weekdays weekday, String startTime, String endTime) {
        this.id = id;
        this.burgerRestaurant = burgerRestaurantId;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
