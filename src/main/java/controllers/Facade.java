package controllers;

public class Facade {
    private final CategoryController categoryController;
    private final NewsController newsController;

    public Facade(String type){
        categoryController = new CategoryControllerImpl(type);
        newsController = new NewsControllerImpl(type);
    }

    public CategoryController getCategoryController() {
        return categoryController;
    }

    public NewsController getNewsController() {
        return newsController;
    }
}
