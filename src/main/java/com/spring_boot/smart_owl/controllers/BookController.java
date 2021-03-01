package com.spring_boot.smart_owl.controllers;

import com.spring_boot.smart_owl.dao.*;
import com.spring_boot.smart_owl.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class BookController {

    private final BookAuthorDAO bookAuthorDAO;
    private final BookGenreDAO bookGenreDAO;
    private final AuthorDAO authorDAO;
    private final BookDAO bookDAO;
    private final GenreDAO genreDAO;
    private final GenreCountDAO genreCountDAO;
    private final AuthorCountDAO authorCountDAO;
    private final RatingDAO ratingDAO;

    public BookController(BookAuthorDAO bookAuthorDAO,
                          BookGenreDAO bookGenreDAO,
                          AuthorDAO authorDAO,
                          BookDAO bookDAO,
                          GenreDAO genreDAO,
                          GenreCountDAO genreCountDAO,
                          AuthorCountDAO authorCountDAO,
                          RatingDAO ratingDAO) {
        this.bookAuthorDAO = bookAuthorDAO;
        this.bookGenreDAO = bookGenreDAO;
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
        this.genreDAO = genreDAO;
        this.genreCountDAO = genreCountDAO;
        this.authorCountDAO = authorCountDAO;
        this.ratingDAO = ratingDAO;
    }

    @GetMapping("/books")
    public String getBooks(Model model,
                           @RequestParam Optional<String> sort) {
        List<BookAuthor> bookAuthorList = null;
        List<BookAuthor> bookAuthors = bookAuthorDAO.getBookAuthors();
        // Sort by title
        List<BookAuthor> bookAuthorsSortByTitleAsc = bookAuthorDAO.getBookAuthorsSortByTitleAsc();
        List<BookAuthor> bookAuthorsSortByTitleDesc = bookAuthorDAO.getBookAuthorsSortByTitleDesc();

        // Sort by author
        List<BookAuthor> bookAuthorsSortByAuthorAsc = bookAuthorDAO.getBookAuthorsSortByAuthorAsc();
        List<BookAuthor> bookAuthorsSortByAuthorDesc = bookAuthorDAO.getBookAuthorsSortByAuthorDesc();

        // Sort by price
        List<BookAuthor> bookAuthorsSortByPriceAsc = bookAuthorDAO.getBookAuthorsSortByPriceAsc();
        List<BookAuthor> bookAuthorsSortByPriceDesc = bookAuthorDAO.getBookAuthorsSortByPriceDesc();

        if (sort.isEmpty()) bookAuthorList = bookAuthors;
        else {
            switch (sort.get()) {
                case "title_asc" -> bookAuthorList = bookAuthorsSortByTitleAsc;
                case "title_desc" -> bookAuthorList = bookAuthorsSortByTitleDesc;
                case "author_asc" -> bookAuthorList = bookAuthorsSortByAuthorAsc;
                case "author_desc" -> bookAuthorList = bookAuthorsSortByAuthorDesc;
                case "price_asc" -> bookAuthorList = bookAuthorsSortByPriceAsc;
                case "price_desc" -> bookAuthorList = bookAuthorsSortByPriceDesc;
            }
        }
        model.addAttribute("book_author_list", bookAuthorList);
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
        book.setOneStar(0);
        book.setTwoStars(0);
        book.setThreeStars(0);
        book.setFourStars(0);
        book.setFiveStars(0);
        book.setPositiveCounter(0.0);
        book.setWilsonScore(0.0);
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
        double ratingValue = rating.getValue();
        if (rating.getValue() != null) {
            switch ((int) ratingValue) {
                case 1 -> bookDAO.updateOneStar(id);
                case 2 -> bookDAO.updateTwoStars(id);
                case 3 -> bookDAO.updateThreeStars(id);
                case 4 -> {
                    bookDAO.updateFourStars(id);
                    bookDAO.updateBookPositiveCounter(id);
                }
                case 5 -> {
                    bookDAO.updateFiveStars(id);
                    bookDAO.updateBookPositiveCounter(id);
                }
            }
            bookDAO.updateRating(ratingValue, id);
            bookDAO.updateWilson(id);
            System.out.println(rating.getValue());
        }
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
    public String getAuthors(Model model,
                             @RequestParam Optional<String> sort) {
        List<AuthorCount> list = null;
        List<AuthorCount> authorCounts = authorCountDAO.getAuthorCounts();
        // Sort by name
        List<AuthorCount> authorCountsSortByAscName = authorCountDAO.getAuthorCountsSortByAscName();
        List<AuthorCount> authorCountsSortByDescName = authorCountDAO.getAuthorCountsSortByDescName();

        // Sort by count
        List<AuthorCount> authorCountsSortByAscCount = authorCountDAO.getAuthorCountsSortByAscCount();
        List<AuthorCount> authorCountsSortByDescCount = authorCountDAO.getAuthorCountsSortByDescCount();


        if (sort.isEmpty()) list = authorCounts;
        else {
            switch (sort.get()) {
                case "author_asc"-> list = authorCountsSortByAscName;
                case "author_desc"-> list = authorCountsSortByDescName;
                case "count_asc"-> list = authorCountsSortByAscCount;
                case "count_desc"-> list = authorCountsSortByDescCount;
            }
        }

        model.addAttribute("authors", list);
        return "authors";
    }

    @GetMapping("/authors/{id}")
    public String getAuthor(@PathVariable Long id,
                            Model model) {
        model.addAttribute("authors", authorCountDAO.getAuthorCount(id));
        return "author";
    }

    @GetMapping("/genres")
    public String getGenres(Model model) {
        model.addAttribute("genres", genreCountDAO.getGenreCounts());
        return "genres";
    }

    @GetMapping("/genres/{id}")
    public String getGenre(@PathVariable Long id,
                          Model model) {
        String genreTitle = genreDAO.findGenreById(id).getGenre();
        model.addAttribute("genreTitle", genreTitle);
        model.addAttribute("book_author_list_by_genre", bookAuthorDAO.getBookAuthorByGenreSortByPrise(genreTitle));
        return "genre";
    }
}
