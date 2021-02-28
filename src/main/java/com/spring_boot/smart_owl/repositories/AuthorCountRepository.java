package com.spring_boot.smart_owl.repositories;

import com.spring_boot.smart_owl.models.AuthorCount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCountRepository extends JpaRepository<AuthorCount, Long> {
}
