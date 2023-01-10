package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public Result getAll(){
        List<Category> categories = categoryService.findAll();
        return ResultUtil.success(categories);
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Result add(@RequestBody Category category) {
        int result = categoryService.addCategory(category);
        if(result == 1) {
            return ResultUtil.success(result);
        }else {
            return ResultUtil.error(400, "添加失败");
        }
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public Result update(@RequestBody Category category) {
        if(category.getId() == null || "".equals(category.getId())){
            return ResultUtil.error(400, "参数缺失");
        }
        int result = categoryService.updateCategory(category);
        if(result >= 1) {
            return ResultUtil.success(result);
        }else {
            return ResultUtil.error(500, "更新失败");
        }
    }

    @RequestMapping(value = "/category/{ids}", method = RequestMethod.DELETE)
    public Result deleteByIds(@PathVariable String ids){
        int result = categoryService.deleteCategoryByIds(ids);
        return ResultUtil.success();
    }
}
