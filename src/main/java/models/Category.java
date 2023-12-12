package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "Category")
public class Category {

    @ManyToOne
    @JoinColumn(name = "news_uuid")
    private News news;

    @JsonProperty("uuid")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid", unique = true, nullable = false)
    private UUID uuid;

    @JsonProperty("text")
    @Column(name = "text")
    private String text;

    public Category() {
    }

    public Category(News news, UUID uuid, String text) {
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

