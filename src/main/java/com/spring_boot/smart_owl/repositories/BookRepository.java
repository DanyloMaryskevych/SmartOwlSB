package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Transactional
    @Modifying
    @Query("update books set rating = (rating * votes + ?1)/(votes + 1), votes = votes + 1 where id = ?2")
    void updateBookRating(Double rating, Long id);

    @Query("select count(b.authorId) from books b where b.authorId = ?1")
    Integer countAuthorsById(Long id);
}
