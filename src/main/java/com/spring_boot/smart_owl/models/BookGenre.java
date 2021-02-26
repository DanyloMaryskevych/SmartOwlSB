package com.spring_boot.smart_owl.models;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

/*
                    *** VIEW QUERY ***
    create or replace view book_genre_view as select
    ROW_NUMBER() OVER(ORDER BY genre), book_id, genre, genre_id from book_genre
    join all_genres ag on ag.id = book_genre.genre_id
*/

@Entity
@Immutable
@Table(name = "'book_genre_view'")
@Subselect("select * from book_genre_view")
public class BookGenre {

    @Id
    @Column(name = "row_number")
    private Long id;
    private Long bookId;
    private Long genreId;

    private String genre;

    public BookGenre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
