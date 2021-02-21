package com.spring_boot.smart_owl.models;

import java.util.List;

public class BookDTO {

    private String title;
    private String description;
    private String image;
    private Double price;
    private Integer amount;
    private String author;
    private List<String> allGenres;

    public BookDTO() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getAllGenres() {
        return allGenres;
    }

    public void setAllGenres(List<String> allGenres) {
        this.allGenres = allGenres;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", author='" + author + '\'' +
                ", allGenres=" + allGenres +
                '}';
    }
}
