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
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;
    private final GenreDAO genreDAO;

    public BookController(BookAuthorDAO bookAuthorDAO,
                          AuthorDAO authorDAO,
                          BookDAO bookDAO,
                          GenreDAO genreDAO) {
        this.bookAuthorDAO = bookAuthorDAO;
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.genreDAO = genreDAO;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorDAO.showAuthors());
        return "show_authors";
    }

    @PostMapping("/authors")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorDAO.addAuthor(author);
        return "redirect:";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("list", bookAuthorDAO.getList());
        return "show_books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model) {
//        model.addAttribute("book_author", new BookAuthor());
        model.addAttribute("book_dto", new BookDTO());
        model.addAttribute("genres", genreDAO.getGenres());
        return "new_book";
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
        bookDAO.addBook(book);

        return "redirect:";
    }
}
