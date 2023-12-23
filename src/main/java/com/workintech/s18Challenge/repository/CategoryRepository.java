package com.workintech.s18Challenge.repository;

import com.workintech.s18Challenge.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
