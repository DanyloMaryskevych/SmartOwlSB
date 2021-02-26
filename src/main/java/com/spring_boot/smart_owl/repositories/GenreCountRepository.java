package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.GenreCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreCountRepository extends JpaRepository<GenreCount, Long> {
}
