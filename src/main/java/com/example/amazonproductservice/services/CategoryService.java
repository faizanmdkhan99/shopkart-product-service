package com.example.amazonproductservice.services;

import com.example.amazonproductservice.models.Category;
import com.example.amazonproductservice.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }
    public Category findCategoryByTitle(String title){
        return categoryRepository.getCategoryByTitle(title);
    }
    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }
}
