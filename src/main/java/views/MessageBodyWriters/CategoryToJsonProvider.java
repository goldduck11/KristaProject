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
import models.Category;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CategoryToJsonProvider implements MessageBodyWriter<Category> {

    private final ObjectMapper objectMapper;

    public CategoryToJsonProvider() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return type == Category.class;
    }

    @Override
    public long getSize(Category category, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Category category, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException {

        StreamingOutput stream = output -> {
            objectMapper.writeValue(output, category);
        };

        stream.write(entityStream);
    }
}
