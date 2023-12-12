package providers;

import controllers.BO.NewsBO;
import models.News;

import java.util.List;
import java.util.UUID;

public interface Provider {
    News getNews(UUID uuid);

    List<NewsBO> getAllNews();
    void update(News news);
    void delete(News news);
    void add(News news);
}
