package com.spring_boot.smart_owl.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "books")
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "title",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String title;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "image",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String image;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "amount",
            nullable = false
    )
    private Integer amount;

    @Column(
            name = "author_id",
            nullable = false
    )
    private Long authorId;

    @Column
    private Double rating;

    @Column
    private Integer votes;

    @ManyToMany(
            fetch = FetchType.LAZY
//            cascade = CascadeType.ALL
            )
    @JoinTable(
            name = "book_genre",
            joinColumns = { @JoinColumn(name = "book_id")},
            inverseJoinColumns = { @JoinColumn(name = "genre_id")}
    )
    private Set<Genre> genreSet = new HashSet<>();

    public Book(String title, String description, String image, Double price, Integer amount, Long authorId) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.amount = amount;
        this.authorId = authorId;
    }

    public Book() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Set<Genre> getGenreSet() {
        return genreSet;
    }
}
