package com.spring_boot.smart_owl.models;

import javax.persistence.*;

/*
    insert into rating(comment, value) VALUES ('did not like it', 1);
    insert into rating(comment, value) VALUES ('it was ok', 2);
    insert into rating(comment, value) VALUES ('liked it', 3);
    insert into rating(comment, value) VALUES ('really liked it', 4);
    insert into rating(comment, value) VALUES ('it was amazing', 5);
*/

@Entity
@Table
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "value")
    private int value;

    @Column(name = "comment")
    private String comment;

    public Rating() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", value=" + value +
                ", comment='" + comment + '\'' +
                '}';
    }
}
