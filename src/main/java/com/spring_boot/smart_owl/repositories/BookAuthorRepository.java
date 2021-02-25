package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

    @Query("from BookAuthor where id = ?1")
    BookAuthor findBookAuthorById(Long id);
}
