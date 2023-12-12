package controllers;

import controllers.DTO.NewsDTO;
import models.News;

import java.util.List;
import java.util.UUID;

public interface NewsController {
    List<NewsDTO> getAllNews();
    NewsDTO getNewsById(UUID uuid);
    List<News> getNewsByCategory(UUID categoryId);
    void createNews(News news);
    void updateNews(UUID uuid);
    void deleteNews(UUID uuid);
}
