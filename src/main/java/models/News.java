package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Entity
    @Table(name = "News")
    public class News {
        @JsonProperty("uuid")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "uuid", unique = true, nullable = false)
        private UUID uuid;

        @JsonProperty("categories")
        @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
        private List<Category> categories;

        @JsonProperty("title")
        @Column(name = "title")
        private String title;

        @JsonProperty("text")
        @Column(name = "text")
        private String text;

        @JsonProperty("date")
        @Column(name = "date")
        private Date date;
        public News(){

        }

        public News(UUID uuid, List<Category> categories, String title, String text, Date date) {
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

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
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

