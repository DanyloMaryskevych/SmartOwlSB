package com.spring_boot.smart_owl.models;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
                    *** VIEW QUERY ***
    create or replace view genre_count as select al.id, al.genre,
    (select count(*) from book_genre bg where bg.genre_id = al.id)
    from all_genres al
*/

@Entity
@Immutable
@Table(name = "'genre_count'")
@Subselect("select * from genre_count")
public class GenreCount {

    @Id
    private Long id;
    private String genre;
    private Integer count;

    public GenreCount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
