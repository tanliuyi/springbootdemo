package com.example.demo.mapper;

import com.example.demo.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<Category> getAllCategory();
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategoryByIds(@Param("ids") String[] ids);
}
