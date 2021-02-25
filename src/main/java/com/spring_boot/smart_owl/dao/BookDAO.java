package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Book;
import com.spring_boot.smart_owl.repositories.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    private final BookRepository bookRepository;

    public BookDAO(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateRating(Double rating, Long id) {
        bookRepository.updateBookRating(rating, id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Long id) {
        return bookRepository.getOne(id);
    }

    public Integer countAuthorsById(Long id) {
        return bookRepository.countAuthorsById(id);
    }

}
