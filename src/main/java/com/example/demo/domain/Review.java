package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*; //todo bad practice with star

@Setter
@Getter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "burger_restaurant_id")
    private BurgerRestaurant burgerRestaurant;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user; //todo not null
    private int tasteScore;
    private int textureScore;
    private int visualScore;
    private String picturePath;
}
