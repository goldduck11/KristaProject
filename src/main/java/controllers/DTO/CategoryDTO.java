package controllers.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import models.News;

import javax.persistence.*;
import java.util.UUID;

public class CategoryDTO {
    private News news;
    private UUID uuid;
    private String text;

    public CategoryDTO() {
    }

    public CategoryDTO(News news, UUID uuid, String text) {
        this.news = news;
        this.uuid = uuid;
        this.text = text;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
