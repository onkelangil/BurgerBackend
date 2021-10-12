package com.example.demo.web.rest.mapper;

import com.example.demo.domain.BurgerRestaurant;
import com.example.demo.domain.Review;
import com.example.demo.domain.User;
import com.example.demo.web.rest.dto.CreateReviewDto;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review map(CreateReviewDto createReviewDto, String userId) {
        Review review = new Review();
        review.setUser(new User(userId));
        review.setPicturePath(createPictureResource(createReviewDto.getPicture()));
        review.setTasteScore(createReviewDto.getTasteScore());
        review.setTextureScore(createReviewDto.getTextureScore());
        review.setVisualScore(createReviewDto.getVisualScore());
        review.setBurgerRestaurant(new BurgerRestaurant(createReviewDto.getBurgerRestaurantId()));
        return review;
    }

    private String createPictureResource(byte[] picture) {
        return "/somePath.jpg";
    }
}
