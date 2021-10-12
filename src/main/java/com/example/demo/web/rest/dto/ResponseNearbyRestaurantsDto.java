package com.example.demo.web.rest.dto;

import com.example.demo.domain.BurgerRestaurant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseNearbyRestaurantsDto {
    private List<BurgerRestaurant> restaurantsDto;

}
