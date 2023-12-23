package com.workintech.s18Challenge.repository;

import com.workintech.s18Challenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
