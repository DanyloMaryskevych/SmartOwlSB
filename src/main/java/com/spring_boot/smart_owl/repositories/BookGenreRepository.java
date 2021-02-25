package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.BookAuthor;
import com.spring_boot.smart_owl.models.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookGenreRepository extends JpaRepository<BookGenre, Long> {

    @Query("from BookGenre where bookId = ?1")
    List<BookGenre> findBookGenresById(Long id);
}
