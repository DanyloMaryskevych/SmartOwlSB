package com.spring_boot.smart_owl.dao;

import com.spring_boot.smart_owl.models.AuthorCount;
import com.spring_boot.smart_owl.repositories.AuthorCountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorCountDAO {

    private final AuthorCountRepository authorCountRepository;

    public AuthorCountDAO(AuthorCountRepository authorCountRepository) {
        this.authorCountRepository = authorCountRepository;
    }

    public List<AuthorCount> getAuthorCountsSortByAscName() {
        return authorCountRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    public List<AuthorCount> getAuthorCountsSortByDescName() {
        return authorCountRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
    }

    public List<AuthorCount> getAuthorCountsSortByAscCount() {
        return authorCountRepository.findAll(Sort.by(Sort.Direction.ASC, "count"));
    }

    public List<AuthorCount> getAuthorCountsSortByDescCount() {
        return authorCountRepository.findAll(Sort.by(Sort.Direction.DESC, "count"));
    }

    public Page<AuthorCount> getPage() {
        return authorCountRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "count")));
    }

    public List<AuthorCount> getAuthorCounts() {
        return authorCountRepository.findAll();
    }

    public Optional<AuthorCount> getAuthorCount(Long id) {
        return authorCountRepository.findById(id);
    }
}
