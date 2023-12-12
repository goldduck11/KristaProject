package controllers.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.Category;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsDTO {
    @JsonProperty("uuid")
    private UUID uuid;

    @JsonProperty("categories")
    private List<CategoryDTO> categories;

    @JsonProperty("title")
    private String title;

    @JsonProperty("date")
    private Date date;

    public NewsDTO() {
    }

    public NewsDTO(UUID uuid, List<CategoryDTO> categories, String title, Date date) {
        this.uuid = uuid;
        this.categories = categories;
        this.title = title;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
