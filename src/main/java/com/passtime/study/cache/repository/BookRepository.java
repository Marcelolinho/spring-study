package com.passtime.study.cache.repository;

import com.passtime.study.cache.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

    Book getByIsbn(String isbn);
    Book getById(Integer id);
}
