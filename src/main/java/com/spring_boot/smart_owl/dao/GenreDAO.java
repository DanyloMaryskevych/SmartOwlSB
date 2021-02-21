package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Genre;
import com.spring_boot.smart_owl.repositories.GenreRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreDAO {

    public final GenreRepository genreRepository;

    public GenreDAO(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }
}
