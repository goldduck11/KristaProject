package MappersObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.BO.CategoryBO;
import controllers.BO.NewsBO;
import models.Category;
import models.News;

public class MapperDOtoBO {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static NewsBO newsDOtoBO(News news) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(news);
        return objectMapper.readValue(json, NewsBO.class);
    }

    public static CategoryBO categoryDOtoBO(Category category) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(category);
        return objectMapper.readValue(json, CategoryBO.class);
    }
}
