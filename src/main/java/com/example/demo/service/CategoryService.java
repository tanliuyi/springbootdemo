package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    int addCategory(Category category);
    int updateCategory(Category category);
    int deleteCategoryByIds(String ids);
}
