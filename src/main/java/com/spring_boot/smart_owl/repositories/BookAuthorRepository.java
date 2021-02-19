package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

}
