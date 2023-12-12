package controllers.BO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import models.Category;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewsBO {
    @JsonProperty("uuid")
    private UUID uuid;
    @JsonProperty("categories")
    private List<CategoryBO> categories;
    @JsonProperty("title")
    private String title;
    @JsonProperty("text")
    private String text;
    @JsonProperty("date")
    private Date date;

    public NewsBO() {
    }

    public NewsBO(UUID uuid, List<CategoryBO> categories, String title, String text, Date date) {
        this.uuid = uuid;
        this.categories = categories;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<CategoryBO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryBO> categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
