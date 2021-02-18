package com.spring_boot.smart_owl.service;

import com.spring_boot.smart_owl.models.BookAuthor;
import com.spring_boot.smart_owl.repositories.BookRepository;
import com.spring_boot.smart_owl.service.IQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Service
public class QueryService implements IQueryService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    EntityManagerFactory emf;

    @Override
    public List<BookAuthor> JPQLQuery() {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery(
                "SELECT b.title, b.description, b.price, b.amount, a.name " +
                "FROM books b JOIN authors a ON b.authorId=a.id");

        @SuppressWarnings("unchecked")
        List<Object[]> resultList =  query.getResultList();
        List<BookAuthor> bookAuthorList = new ArrayList<>();

        for (Object[] line : resultList) {
            BookAuthor bookAuthor = new BookAuthor();

            bookAuthor.setTitle((String) line[0]);
            bookAuthor.setDescription((String) line[1]);
            bookAuthor.setPrice((Double) line[2]);
            bookAuthor.setAmount((Integer) line[3]);
            bookAuthor.setAuthor((String) line[4]);

            bookAuthorList.add(bookAuthor);
        }

        em.close();

        return bookAuthorList;
    }
}
