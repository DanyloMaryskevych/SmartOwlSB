package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
