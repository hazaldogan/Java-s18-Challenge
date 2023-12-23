package com.workintech.s18Challenge.repository;

import com.workintech.s18Challenge.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
