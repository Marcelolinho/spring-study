package com.passtime.study.cache.controller;

import com.passtime.study.cache.domain.Book;
import com.passtime.study.cache.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@Slf4j
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public List<Book> postBooks() {
        List<Book> books = new ArrayList<>();

        books.add(bookRepository.getByIsbn("1234 teste"));
        log.info("Primeiro adicionado");
        books.add(bookRepository.getByIsbn("Marcelo's Story"));
        log.info("Segundo adicionado");
        books.add(bookRepository.getByIsbn("Marcelo's Story"));
        log.info("Terceiro adicionado");
        books.add(bookRepository.getByIsbn("Marcelo's Story"));
        log.info("Quarto adicionado");
        books.add(bookRepository.getByIsbn("1234 teste"));
        log.info("Quinto adicionado");
        books.add(bookRepository.getByIsbn("1234"));
        log.info("Último adicionado");

        return books;
    }

    @GetMapping("/{test}")
    public Book getBookById(@PathVariable Integer test) {
        log.debug("A");
        Book b = bookRepository.getById(test);
        log.info("Teste");
        return bookRepository.getById(test);
    }
}
