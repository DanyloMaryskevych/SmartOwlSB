package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.GenreCount;
import com.spring_boot.smart_owl.repositories.GenreCountRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreCountDAO {

    private final GenreCountRepository genreCountRepository;

    public GenreCountDAO(GenreCountRepository genreCountRepository) {
        this.genreCountRepository = genreCountRepository;
    }

    public List<GenreCount> getGenreCounts() {
        return genreCountRepository.findAll();
    }
}
