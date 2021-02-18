package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("FROM authors WHERE name = ?1")
    List<Author> findAuthorByName(String name);
}
