package com.workintech.s18Challenge.service;

import com.workintech.s18Challenge.entity.Category;
import com.workintech.s18Challenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findById(long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            return categoryOptional.get();
        }

        throw new RuntimeException("Category is not found with given id: " + id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
