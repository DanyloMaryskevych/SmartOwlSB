package com.spring_boot.smart_owl.controllers;

import com.spring_boot.smart_owl.dao.AuthorDAO;
import com.spring_boot.smart_owl.dao.BookDAO;
import com.spring_boot.smart_owl.models.Author;
import com.spring_boot.smart_owl.models.Book;
import com.spring_boot.smart_owl.models.BookAuthor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class BookController {

    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    public BookController(AuthorDAO authorDAO, BookDAO bookDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorDAO.showAuthors());
        return "show_authors";
    }

    @GetMapping("/authors/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "new_author";
    }

    @PostMapping("/authors")
    public String addAuthor(@ModelAttribute("author") Author author) {
        authorDAO.addAuthor(author);
        return "redirect:";
    }

    @GetMapping("/books")
    public String getBooks() {
        return "show_books";
    }

    @GetMapping("/books/new")
    public String newBook(Model model) {
        model.addAttribute("book_author", new BookAuthor());
        return "new_book";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute("book_author") BookAuthor bookAuthor) {
        String authorName = bookAuthor.getAuthor();
        Long authorId;
        List<Author> someAuthor = authorDAO.findAuthor(authorName);

        if (someAuthor.size() == 1) {
            authorId = someAuthor.get(0).getId();
        }
        else {
            Author author = new Author(authorName);
            authorDAO.addAuthor(author);
            authorId = authorDAO.findAuthor(authorName).get(0).getId();
        }

        Book book = new Book(
                bookAuthor.getTitle(), bookAuthor.getDescription(),
                bookAuthor.getPrice(), bookAuthor.getAmount(), authorId);
        bookDAO.addBook(book);
        return "redirect:";
    }
}
