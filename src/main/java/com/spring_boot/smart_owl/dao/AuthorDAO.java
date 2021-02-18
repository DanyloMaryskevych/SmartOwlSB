package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.Author;
import com.spring_boot.smart_owl.repositories.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorDAO {

    private final AuthorRepository authorRepository;

    public AuthorDAO(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> showAuthors() {
        return authorRepository.findAll();
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public List<Author> findAuthor(String name) {
        return authorRepository.findAuthorByName(name);
    }
}
