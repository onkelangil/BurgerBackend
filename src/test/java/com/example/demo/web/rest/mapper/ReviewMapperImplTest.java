package com.example.demo.web.rest.mapper;


import com.example.demo.domain.Review;
import com.example.demo.web.rest.dto.CreateReviewDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class ReviewMapperImplTest {
    private ReviewMapper mapper;


    @Test
    public void testReviewMapperImpl() {
        mapper = new ReviewMapperImpl();
        //given
        String randomId = "randomId";
        String randomToken = "fakeJWTToken";
        int tasteScore = 6;
        int textureScore = 4;
        int visualScore = 3;
        byte[] picture = new byte[0];

        CreateReviewDto reviewDto = new CreateReviewDto(randomId, tasteScore, textureScore, visualScore, picture);
        //when
        Review result = mapper.map(reviewDto, randomToken);
        //then
        Assertions.assertEquals("/somePath.jpg", result.getPicturePath());
        Assertions.assertEquals("fakeJWTToken", result.getUser().getId());
        Assertions.assertEquals(6, result.getTasteScore());
    }
}
