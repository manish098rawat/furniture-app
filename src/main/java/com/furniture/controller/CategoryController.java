package com.furniture.controller;

import com.furniture.model.Category;
import com.furniture.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3006)
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAllCategory() {

        return categoryService.getAllCategory();

    }
    @GetMapping("/{name}")
    public Category getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
    @PostMapping("/create")
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{categoryId}/product/{productId}")
    public void enrollCategory(@PathVariable int categoryId, @PathVariable int productId){
        categoryService.enrollCategory(categoryId,productId);

    }


}