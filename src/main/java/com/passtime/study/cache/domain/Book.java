package com.passtime.study.cache.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer id;
    private String isbn;
    private String title;

    public void nextId() {
        this.id += 1;
    }
}
