package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query("from all_genres where genre = ?1")
    Genre findGenreByName(String genre);

    @Query("from all_genres where id = ?1")
    Genre findGenreById(Long id);
}
