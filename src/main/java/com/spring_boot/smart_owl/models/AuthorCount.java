package com.spring_boot.smart_owl.models;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
                    *** VIEW QUERY ***
    create or replace view author_count as select
    a.id as id, a.name,
    (select count(*) from books b where b.author_id = a.id)
    from authors a
*/

@Entity
@Immutable
@Table(name = "'author_count'")
@Subselect("select * from author_count")
public class AuthorCount {

    @Id
    private Long id;
    private String name;
    private Integer count;

    public AuthorCount() {
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
