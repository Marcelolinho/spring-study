package com.passtime.study.cache.repository;

import com.passtime.study.cache.domain.Book;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Objects;

@Repository
public class SimpleBookRepository implements BookRepository{

    ArrayList<Book> books = new ArrayList<>();

    @Override
    @Cacheable(value = "books", key = "#isbn")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        Book book = new Book(nextId(books), isbn, "Some book");
        books.add(book);
        return book;
    }

    @Override
    @Cacheable(value = "books", key = "#id", condition = "#id = 2")
    public Book getById(Integer id) {
        return books.stream()
                    .filter(b -> b.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private Integer nextId(ArrayList<Book> booksSaved) {
        if (booksSaved == null || booksSaved.isEmpty()) {
            return 1;
        }

        return booksSaved.getLast().getId() + 1;
    }
}
