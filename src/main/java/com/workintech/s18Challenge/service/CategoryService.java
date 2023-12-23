package com.workintech.s18Challenge.service;

import com.workintech.s18Challenge.entity.Category;

public interface CategoryService {
    Category findById(long id);
    Category save(Category category);
}
