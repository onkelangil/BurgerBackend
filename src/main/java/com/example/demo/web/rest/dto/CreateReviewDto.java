package com.example.demo.web.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto { //todo vi har ikke userId med da brugerne ville kunne skrive andre id'er på
    private String burgerRestaurantId;
    private int tasteScore;
    private int textureScore;
    private int visualScore;
    private byte[] picture;

    public CreateReviewDto(String burgerRestaurantId, int tasteScore, int textureScore, int visualScore, byte[] picture) {
        this.burgerRestaurantId = burgerRestaurantId;
        this.tasteScore = tasteScore;
        this.textureScore = textureScore;
        this.visualScore = visualScore;
        this.picture = picture;
    }
}
