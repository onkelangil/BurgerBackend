package com.example.demo.web.rest.mapper;

import com.example.demo.domain.Review;
import com.example.demo.web.rest.dto.CreateReviewDto;
import org.springframework.stereotype.Component;

@Component
public interface ReviewMapper {
    Review map(CreateReviewDto createReviewDto, String jwt);
}
