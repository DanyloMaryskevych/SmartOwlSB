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

    @Transactional
    @Modifying
    @Query("update books set wilsonScore = ( positiveCounter / votes + 1.9208 / votes - 1.96 * " +
            "sqrt( (positiveCounter * (votes - positiveCounter)) / (votes * votes * votes) + 0.9604 / (votes * votes)) ) " +
            "/ (1 + 3.8416/votes)  where id = ?1")
    void updateBookWilson(Long id);

    @Transactional
    @Modifying
    @Query("update books set oneStar = oneStar + 1 where id = ?1")
    void updateBookOneStar(Long id);

    @Transactional
    @Modifying
    @Query("update books set twoStars = twoStars + 1 where id = ?1")
    void updateBookTwoStars(Long id);

    @Transactional
    @Modifying
    @Query("update books set threeStars = threeStars + 1 where id = ?1")
    void updateBookThreeStars(Long id);

    @Transactional
    @Modifying
    @Query("update books set fourStars = fourStars + 1 where id = ?1")
    void updateBookFourStars(Long id);

    @Transactional
    @Modifying
    @Query("update books set fiveStars = fiveStars + 1 where id = ?1")
    void updateBookFiveStars(Long id);

    @Transactional
    @Modifying
    @Query("update books set positiveCounter = positiveCounter + 1 where id = ?1")
    void updateBookPositiveCounter(Long id);

    @Query("select count(b.authorId) from books b where b.authorId = ?1")
    Integer countAuthorsById(Long id);


}
