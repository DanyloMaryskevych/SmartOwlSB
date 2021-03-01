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
    private Integer oneStar;

    @Column
    private Integer twoStars;

    @Column
    private Integer threeStars;

    @Column
    private Integer fourStars;

    @Column
    private Integer fiveStars;

    @Column
    private Double positiveCounter;

    @Column
    private Double wilsonScore;

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

    public Integer getOneStar() {
        return oneStar;
    }

    public void setOneStar(Integer oneStar) {
        this.oneStar = oneStar;
    }

    public Integer getTwoStars() {
        return twoStars;
    }

    public void setTwoStars(Integer twoStars) {
        this.twoStars = twoStars;
    }

    public Integer getThreeStars() {
        return threeStars;
    }

    public void setThreeStars(Integer threeStars) {
        this.threeStars = threeStars;
    }

    public Integer getFourStars() {
        return fourStars;
    }

    public void setFourStars(Integer fourStars) {
        this.fourStars = fourStars;
    }

    public Integer getFiveStars() {
        return fiveStars;
    }

    public void setFiveStars(Integer fiveStars) {
        this.fiveStars = fiveStars;
    }

    public Double getPositiveCounter() {
        return positiveCounter;
    }

    public void setPositiveCounter(Double positiveCounter) {
        this.positiveCounter = positiveCounter;
    }

    public Double getWilsonScore() {
        return wilsonScore;
    }

    public void setWilsonScore(Double wilsonScore) {
        this.wilsonScore = wilsonScore;
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
