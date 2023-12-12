package views.MessageBodyWriters;

import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.DTO.NewsDTO;
import models.News;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class NewsDTOtoJsonProvider implements MessageBodyWriter<NewsDTO> {

    private final ObjectMapper objectMapper;

    public NewsDTOtoJsonProvider() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == NewsDTO.class;
    }

    @Override
    public long getSize(NewsDTO news, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(NewsDTO news, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException {

        StreamingOutput stream = output -> {
            objectMapper.writeValue(output, news);
        };

        stream.write(entityStream);
    }
}
