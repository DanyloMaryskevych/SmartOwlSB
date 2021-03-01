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

    public void updateWilson(Long id) {
        bookRepository.updateBookWilson(id);
    }

    public void updateOneStar(Long id) { bookRepository.updateBookOneStar(id);}
    public void updateTwoStars(Long id) { bookRepository.updateBookTwoStars(id);}
    public void updateThreeStars(Long id) { bookRepository.updateBookThreeStars(id);}
    public void updateFourStars(Long id) { bookRepository.updateBookFourStars(id);}
    public void updateFiveStars(Long id) { bookRepository.updateBookFiveStars(id);}

    public void updateBookPositiveCounter(Long id) { bookRepository.updateBookPositiveCounter(id);}

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
