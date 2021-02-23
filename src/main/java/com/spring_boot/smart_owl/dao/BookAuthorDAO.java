package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Book;
import com.spring_boot.smart_owl.models.BookAuthor;
import com.spring_boot.smart_owl.repositories.BookAuthorRepository;
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

    public List<BookAuthor> getByPrice(Double price) {
        return bookAuthorRepository.findBookAuthorByPrice(price);
    }

    public Double getSum() {
        return bookAuthorRepository.getSum();
    }

    public BookAuthor getBookAuthorById(Long id) {
        return bookAuthorRepository.findBookAuthorById(id);
    }
}
