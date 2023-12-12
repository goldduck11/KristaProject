package MappersObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.BO.CategoryBO;
import controllers.BO.NewsBO;
import controllers.DTO.CategoryDTO;
import controllers.DTO.NewsDTO;

public class MapperBOtoDTO {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static NewsDTO newsBOtoDTO(NewsBO newsBO) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(newsBO);
        return objectMapper.readValue(json, NewsDTO.class);
    }

    public static CategoryDTO categoryBOtoDTO(CategoryBO categoryBO) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(categoryBO);
        return objectMapper.readValue(json, CategoryDTO.class);
    }
}
