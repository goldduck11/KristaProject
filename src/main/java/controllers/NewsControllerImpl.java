package controllers;

import MappersObject.MapperBOtoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.DTO.NewsDTO;
import providers.Factory;
import models.News;
import providers.Provider;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NewsControllerImpl implements NewsController {
    Provider provider;
    public NewsControllerImpl(String type) {
        provider = Factory.create(type);
    }

    public List<NewsDTO> getAllNews() {
        return provider.getAllNews().stream().map(news -> {
            try {
                return MapperBOtoDTO.newsBOtoDTO(news);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    public NewsDTO getNewsById(UUID uuid) {
        return provider.getAllNews().stream()
                .filter(news -> news.getUuid().equals(uuid))
                .findFirst()
                .map(news -> {
                    try {
                        return MapperBOtoDTO.newsBOtoDTO(news);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .orElse(null);
    }

    public List<News> getNewsByCategory(UUID uuid) {
        return null;
    }

    public void createNews(News news) {
        provider.add(news);
    }

    public void updateNews(UUID uuid) {

    }

    public void deleteNews(UUID uuid) {

    }
}
