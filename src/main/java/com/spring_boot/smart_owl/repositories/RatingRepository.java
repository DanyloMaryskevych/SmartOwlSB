package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
