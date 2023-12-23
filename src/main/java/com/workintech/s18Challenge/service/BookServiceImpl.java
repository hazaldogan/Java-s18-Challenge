package com.workintech.s18Challenge.service;

import com.workintech.s18Challenge.entity.Book;
import com.workintech.s18Challenge.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }
        throw new RuntimeException("Book is not found with given id!");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
