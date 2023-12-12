package providers;

import MappersObject.MapperDOtoBO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controllers.BO.NewsBO;
import models.Category;
import models.News;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.*;
import java.util.stream.Collectors;

public class MongoDBProvider implements Provider {
    private final String MONGO_URI = "mongodb://localhost:27017";
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<News> newsCollection;
    private final MongoCollection<Category> categoryCollection;
    private final CodecRegistry codecRegistry = CodecRegistries.fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
    );

    public MongoDBProvider() {
        this.client = new MongoClient(new MongoClientURI(MONGO_URI));
        this.database = client.getDatabase("NewsService").withCodecRegistry(codecRegistry);
        this.newsCollection = database.getCollection("News", News.class);
        this.categoryCollection = database.getCollection("Category", Category.class);
    }

    @Override
    public News getNews(UUID uuid) {
        Document query = new Document("uuid", uuid.toString());
        return newsCollection.find(query, News.class).first();
    }

    @Override
    public List<NewsBO> getAllNews() {
        List<News> newsList = new ArrayList<>();
        for (News news : newsCollection.find()) {
            newsList.add(news);
        }
        return newsList.stream().map(news -> {
            try {
                return MapperDOtoBO.newsDOtoBO(news);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    @Override
    public void update(News news) {
        UUID uuid = news.getUuid();
        Document query = new Document("uuid", uuid.toString());
        News existingNews = newsCollection.find(query, News.class).first();

        if (existingNews != null) {
            newsCollection.replaceOne(query, news);
        }
    }

    @Override
    public void delete(News news) {
        UUID uuid = news.getUuid();
        newsCollection.deleteOne(new Document("uuid", uuid.toString()));
    }

    @Override
    public void add(News news) {
        newsCollection.insertOne(news);
    }
}
