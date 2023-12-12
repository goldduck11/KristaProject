package views;

import controllers.DTO.NewsDTO;
import controllers.Facade;
import models.Category;
import models.News;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Path("/write")
public class WriterApi {
    private final Facade facade = new Facade("postgre");

    @POST
    @Path("/categories")
    public void createCategory(Category category) {
        facade.getCategoryController().createCategory(category);
    }

    @PUT
    @Path("/categories/{uuid}")
    public void updateCategory(@PathParam("uuid") UUID uuid, Category category) {
        facade.getCategoryController().updateCategory(uuid, category);
    }

    @GET
    @Path("/news")
    public List<NewsDTO> getAllNews(){
        return facade.getNewsController().getAllNews();
    }

    @GET
    @Path("/news/get/{uuid}")
    public NewsDTO getNewsByUuid(@PathParam("uuid") UUID uuid) {
        return facade.getNewsController().getNewsById(uuid);
    }

    @GET
    @Path("/news/add")
    public Response createNews(    @QueryParam("title") String title,
                                   @QueryParam("text") String text
    ) {
        News news = new News(UUID.randomUUID(), null, title, text, null);
        facade.getNewsController().createNews(news);
        return Response.ok("News added successfully").entity(news).build();
    }

    @GET
    @Path("/news/update/{uuid}")
    public void updateNews(@PathParam("uuid") UUID uuid) {
        facade.getNewsController().updateNews(uuid);
    }
}
