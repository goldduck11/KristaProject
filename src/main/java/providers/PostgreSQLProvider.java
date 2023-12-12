package providers;

import MappersObject.MapperDOtoBO;
import com.fasterxml.jackson.core.JsonProcessingException;
import controllers.BO.NewsBO;
import models.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PostgreSQLProvider implements Provider {
    private final SessionFactory sessionFactory =
            new Configuration().configure("hibernatePostgre.cfg.xml").buildSessionFactory();

    @Override
    public void add(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public News getNews(UUID uuid) {
        return null;
    }

    @Override
    public List<NewsBO> getAllNews() {
        try (Session session = sessionFactory.openSession()) {
            Query<News> query = session.createQuery("from News", News.class);
            return query.list().stream().map(news -> {
                try {
                    return MapperDOtoBO.newsDOtoBO(news);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        }
    }

    @Override
    public void update(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(News news) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(news);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
