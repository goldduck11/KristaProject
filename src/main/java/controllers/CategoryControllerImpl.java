package controllers;

import models.Category;
import providers.Factory;
import providers.Provider;

import java.util.List;
import java.util.UUID;

public class CategoryControllerImpl implements CategoryController {
    Provider provider;
    public CategoryControllerImpl(String type) {
        provider = Factory.create(type);
    }

    public List<Category> getAllCategories() {
        return null;
    }

    public Category getCategoryById(UUID uuid) {
        return null;
    }

    public void createCategory(Category category) {

    }

    public void updateCategory(UUID uuid, Category category) {

    }

    public void deleteCategory(UUID uuid) {

    }
}
