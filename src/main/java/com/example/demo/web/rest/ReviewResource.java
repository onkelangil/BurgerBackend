package com.example.demo.web.rest;

import com.example.demo.domain.Review;
import com.example.demo.service.BurgerRestaurantService;
import com.example.demo.service.ReviewService;
import com.example.demo.util.SecurityUtil;
import com.example.demo.web.rest.dto.CreateReviewDto;
import com.example.demo.web.rest.dto.ResponseNearbyRestaurantsDto;
import com.example.demo.web.rest.mapper.ReviewMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReviewResource {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;
    private final BurgerRestaurantService burgerRestaurantService;

    public ReviewResource(ReviewMapper reviewMapper, ReviewService reviewService, BurgerRestaurantService burgerRestaurantService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
        this.burgerRestaurantService = burgerRestaurantService;
    }

    @PostMapping("/v1/review")
    public void createReview(@RequestHeader("jwt") String jwt, @RequestBody CreateReviewDto createReviewDto) {
        Review test = reviewMapper.map(createReviewDto, jwt);
        reviewService.create(test);
    }

    @GetMapping("/v1/restaurants")
    public ResponseNearbyRestaurantsDto getRestaurants(@RequestHeader("jwt") String jwt, @RequestParam double latitude, @RequestParam double longitude) {
        String userId = SecurityUtil.getUserId(jwt);
        ResponseNearbyRestaurantsDto nearbyRestaurantsDto = new ResponseNearbyRestaurantsDto();
        nearbyRestaurantsDto.setRestaurantsDto(burgerRestaurantService.findNearbyRestaurants(userId));
        return nearbyRestaurantsDto;
    }
}
