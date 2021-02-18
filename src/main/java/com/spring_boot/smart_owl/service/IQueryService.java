package com.spring_boot.smart_owl.service;

import com.spring_boot.smart_owl.models.BookAuthor;

import java.util.List;

public interface IQueryService {

    List<BookAuthor> JPQLQuery();
}
