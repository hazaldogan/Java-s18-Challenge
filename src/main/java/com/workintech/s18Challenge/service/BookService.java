package com.workintech.s18Challenge.service;

import com.workintech.s18Challenge.entity.Book;

public interface BookService {
    Book findById(long id);
    Book save(Book book);
}
