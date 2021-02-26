package com.spring_boot.smart_owl.controllers;

import com.spring_boot.smart_owl.dao.*;
import com.spring_boot.smart_owl.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class BookController {

    private final BookAuthorDAO bookAuthorDAO;
    private final BookGenreDAO bookGenreDAO;
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;
    private final GenreDAO genreDAO;
    private final GenreCountDAO genreCountDAO;
    private final RatingDAO ratingDAO;

    public BookController(BookAuthorDAO bookAuthorDAO,
                          BookGenreDAO bookGenreDAO,
                          AuthorDAO authorDAO,
                          BookDAO bookDAO,
                          GenreDAO genreDAO,
                          GenreCountDAO genreCountDAO,
                          RatingDAO ratingDAO) {
        this.bookAuthorDAO = bookAuthorDAO;
        this.bookGenreDAO = bookGenreDAO;
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.genreDAO = genreDAO;
        this.genreCountDAO = genreCountDAO;
        this.ratingDAO = ratingDAO;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("book_author_list", bookAuthorDAO.getBookAuthors());
        return "store";
    }

    @PostMapping("/books")
    public String addBook(Model model,
                          BookDTO bookDTO) {

        model.addAttribute("book_dto", bookDTO);

        String authorName = bookDTO.getAuthor();
        Long authorId;
        List<Author> someAuthor = authorDAO.findAuthor(authorName);

        if (someAuthor.size() == 1) {
            authorId = someAuthor.get(0).getId();
        }
        else {
            Author author = new Author(authorName);
            authorDAO.addAuthor(author);
            authorId = author.getId();
        }

        Book book = new Book(
                bookDTO.getTitle(), bookDTO.getDescription(), bookDTO.getImage(),
                bookDTO.getPrice(), bookDTO.getAmount(), authorId);

        for (String genreString : bookDTO.getAllGenres()) {
            Genre genre = genreDAO.getGenre(genreString);
            book.getGenreSet().add(genre);
        }
        book.setRating(0.0);
        book.setVotes(0);
        bookDAO.addBook(book);

        return "redirect:/books";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id,
                          Model model) {
        model.addAttribute("current_book", bookAuthorDAO.getBookAuthorById(id));
        model.addAttribute("current_book_genres", bookGenreDAO.findBookGenresById(id));
        model.addAttribute("ratings", ratingDAO.getRatings());
        model.addAttribute("current_rating", new Rating());
        return "book";
    }

    @PostMapping("/books/{id}")
    public String addRating(@PathVariable Long id,
                            Model model,
                            Rating rating) {
        model.addAttribute("current_rating", rating);
        if (rating.getValue() != null) bookDAO.updateRating(rating.getValue(), id);
        return "redirect:/books/{id}";
    }

    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("book_dto", new BookDTO());
        model.addAttribute("genres", genreDAO.getGenres());
        return "new_book";
    }

    @PostMapping("/books/{id}/delete")
    public String deleteBookGet(@PathVariable Long id) {
        Long authorId = bookDAO.getBookById(id).getAuthorId();
        Integer authorsCounter = bookDAO.countAuthorsById(authorId);

        bookDAO.deleteBook(id);
        if (authorsCounter == 1) {
            authorDAO.deleteAuthor(authorId);
        }
        return "redirect:/books";
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorDAO.showAuthors());
        return "authors";
    }

    @GetMapping("/genres")
    public String getGenres(Model model) {
        model.addAttribute("genres", genreCountDAO.getGenreCounts());
        return "genres";
    }

    @GetMapping("/genres/{id}")
    public String getGenre(@PathVariable Long id,
                          Model model) {
        model.addAttribute("book_author_list_by_genre", bookAuthorDAO.getBookAuthorByGenre(genreDAO.findGenreById(id).getGenre()));
        return "genre";
    }
}
