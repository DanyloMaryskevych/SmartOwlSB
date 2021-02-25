package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.BookGenre;
import com.spring_boot.smart_owl.repositories.BookGenreRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookGenreDAO {

    private final BookGenreRepository bookGenreRepository;

    public BookGenreDAO(BookGenreRepository bookGenreRepository) {
        this.bookGenreRepository = bookGenreRepository;
    }

    public List<BookGenre> getBookGenres() {
        return bookGenreRepository.findAll();
    }

    public List<BookGenre> findBookGenresById(Long id) {
        return bookGenreRepository.findBookGenresById(id);
    }

}
