package com.example.demo.web.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class CreateReviewDto { //todo vi har ikke userId med da brugerne ville kunne skrive andre id'er på
    private String burgerRestaurantId;
    private int tasteScore;
    private int textureScore;
    private int visualScore;
    private byte picture;
}
