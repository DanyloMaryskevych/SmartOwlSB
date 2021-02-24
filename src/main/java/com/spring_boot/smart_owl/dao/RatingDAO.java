package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Rating;
import com.spring_boot.smart_owl.repositories.RatingRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RatingDAO {

    private final RatingRepository ratingRepository;

    public RatingDAO(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }
}
