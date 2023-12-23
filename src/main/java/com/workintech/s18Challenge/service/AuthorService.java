package com.workintech.s18Challenge.service;


import com.workintech.s18Challenge.entity.Author;

import java.util.List;

public interface AuthorService {
    Author findById(long id);
    Author save(Author author);
}
