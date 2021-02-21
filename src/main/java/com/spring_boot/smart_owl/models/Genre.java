package com.spring_boot.smart_owl.models;

import javax.persistence.*;

/*                  *** Add Genres ****
    insert into all_genres(genre) VALUES ('Fantasy');
    insert into all_genres(genre) VALUES ('Adventure');
    insert into all_genres(genre) VALUES ('Romance');
    insert into all_genres(genre) VALUES ('Contemporary');
    insert into all_genres(genre) VALUES ('Dystopian');
    insert into all_genres(genre) VALUES ('Mystery');
    insert into all_genres(genre) VALUES ('Horror');
    insert into all_genres(genre) VALUES ('Thriller');
    insert into all_genres(genre) VALUES ('Paranormal');
    insert into all_genres(genre) VALUES ('Historical fiction');
    insert into all_genres(genre) VALUES ('Science Fiction');
    insert into all_genres(genre) VALUES ('Memoir');
    insert into all_genres(genre) VALUES ('Cooking');
    insert into all_genres(genre) VALUES ('Art');
    insert into all_genres(genre) VALUES ('Personal');
    insert into all_genres(genre) VALUES ('Development');
    insert into all_genres(genre) VALUES ('Motivational');
    insert into all_genres(genre) VALUES ('Health');
    insert into all_genres(genre) VALUES ('History');
    insert into all_genres(genre) VALUES ('Travel');
    insert into all_genres(genre) VALUES ('Guide');
    insert into all_genres(genre) VALUES ('Families & Relationships');
    insert into all_genres(genre) VALUES ('Humor');
    insert into all_genres(genre) VALUES ('Children’s');

*/

@Entity
@Table(name = "all_genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private String genre;

    public Long getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }
}
