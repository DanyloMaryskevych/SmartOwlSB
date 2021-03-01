package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Book;
import com.spring_boot.smart_owl.models.BookAuthor;
import com.spring_boot.smart_owl.repositories.BookAuthorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookAuthorDAO {

    private final BookAuthorRepository bookAuthorRepository;

    public BookAuthorDAO(BookAuthorRepository bookAuthorRepository) {
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public List<BookAuthor> getBookAuthors() {
        return bookAuthorRepository.findAll();
    }

    public List<BookAuthor> getBookAuthorsSortByTitleAsc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.ASC, "title"));
    }

    public List<BookAuthor> getBookAuthorsSortByTitleDesc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.DESC, "title"));
    }

    public List<BookAuthor> getBookAuthorsSortByAuthorAsc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.ASC, "author"));
    }

    public List<BookAuthor> getBookAuthorsSortByAuthorDesc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.DESC, "author"));
    }

    public List<BookAuthor> getBookAuthorsSortByPriceAsc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }

    public List<BookAuthor> getBookAuthorsSortByPriceDesc() {
        return bookAuthorRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }

    public BookAuthor getBookAuthorById(Long id) {
        return bookAuthorRepository.findBookAuthorById(id);
    }

    public List<BookAuthor> getBookAuthorByGenre(String genre) {
        return bookAuthorRepository.getBookAuthorByGenre(genre);
    }

    public List<BookAuthor> getBookAuthorByGenreSortByPrise(String genre) {
        return bookAuthorRepository.getBookAuthorByGenreSortByPrise(genre);
    }
}
