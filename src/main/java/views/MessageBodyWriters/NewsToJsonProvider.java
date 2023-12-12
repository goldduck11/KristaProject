package views.MessageBodyWriters;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.News;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class NewsToJsonProvider implements MessageBodyWriter<News> {

    private final ObjectMapper objectMapper;

    public NewsToJsonProvider() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == News.class;
    }

    @Override
    public long getSize(News news, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(News news, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException {

        StreamingOutput stream = output -> {
            objectMapper.writeValue(output, news);
        };

        stream.write(entityStream);
    }
}

