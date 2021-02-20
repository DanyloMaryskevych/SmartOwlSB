package com.spring_boot.smart_owl.models;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
                *** VIEW QUERY ***
    create or replace view book_author as select
    b.id, title, description, price, amount, name
    from books b INNER JOIN authors a on b.author_id = a.id
*/

@Entity
@Immutable
@Table(name = "'book_author'")
@Subselect("select * from book_author")
public class BookAuthor {

    @Id
    @Column(name = "id")
    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer amount;
    @Column(name = "name")
    private String author;

    public BookAuthor() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
