package controllers;

import models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryController {
    List<Category> getAllCategories();
    Category getCategoryById(UUID uuid);
    void createCategory(Category category);
    void updateCategory(UUID uuid, Category category);
    void deleteCategory(UUID uuid);
}
