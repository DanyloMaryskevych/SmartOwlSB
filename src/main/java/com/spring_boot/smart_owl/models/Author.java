package com.spring_boot.smart_owl.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "authors")
@Table(name = "authors")
public class Author {

//    @Id
//    @SequenceGenerator(
//            name = "authors_sequence",
//            sequenceName = "authors_sequence",
//            allocationSize = 1,
//            initialValue = 2
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "authors_sequence"
//    )
//    @Column(
//            name = "id",
//            updatable = false,
//            nullable = false
//    )
//    private Long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "author_id",
            referencedColumnName = "id"
    )
    List<Book> bookList = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

}
