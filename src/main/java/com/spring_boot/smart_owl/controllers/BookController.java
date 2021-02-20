package com.spring_boot.smart_owl.controllers;

import com.spring_boot.smart_owl.GenreList;
import com.spring_boot.smart_owl.Genres;
import com.spring_boot.smart_owl.dao.BookAuthorDAO;
import com.spring_boot.smart_owl.dao.AuthorDAO;
import com.spring_boot.smart_owl.dao.BookDAO;
import com.spring_boot.smart_owl.models.Author;
import com.spring_boot.smart_owl.models.BookAuthor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping
public class BookController {

    private final BookAuthorDAO bookAuthorDAO;
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;

    public BookController(BookAuthorDAO bookAuthorDAO, AuthorDAO authorDAO, BookDAO bookDAO) {
        this.bookAuthorDAO = bookAuthorDAO;
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
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
        model.addAttribute("book_author", new BookAuthor());
        model.addAttribute("genreList", new GenreList());
        return "new_book";
    }

    @PostMapping("/books")
    public String addBook(GenreList genreList, Model model) {

        model.addAttribute("genreList", genreList);

        for (int i = 0; i < genreList.getGenres().length; i++) {
            System.out.println("Genre #" + (i + 1) + ": " + genreList.getGenres()[i]);
        }

//        List<String> list = new ArrayList<>();
//
//        for (int index = 0; index < 10; index++) {
//            String title = "title" + index;
//            String input = request.getParameter(title);
//
//            if (input == null) {
//                break;
//            }
//
//            list.add(input);
//        }
//
//        System.out.println(list);
//
//
//        String authorName = bookAuthor.getAuthor();
//        Long authorId;
//        List<Author> someAuthor = authorDAO.findAuthor(authorName);
//
//        if (someAuthor.size() == 1) {
//            authorId = someAuthor.get(0).getId();
//        }
//        else {
//            Author author = new Author(authorName);
//            authorDAO.addAuthor(author);
//            authorId = author.getId();
//        }
//
//        Book book = new Book(
//                bookAuthor.getTitle(), bookAuthor.getDescription(),
//                bookAuthor.getPrice(), bookAuthor.getAmount(), authorId);
//        bookDAO.addBook(book);
        return "redirect:";
    }
}
