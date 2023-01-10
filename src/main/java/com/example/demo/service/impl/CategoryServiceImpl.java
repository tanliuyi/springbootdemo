package com.example.demo.service.impl;

import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.getAllCategory();
    }

    @Override
    public int addCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        System.out.println(category);
        return categoryMapper.insertCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        category.setDate(new Timestamp(System.currentTimeMillis()));
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryByIds(String ids) {
        String[] split = ids.split(",");
        return categoryMapper.deleteCategoryByIds(split);
    }
}
