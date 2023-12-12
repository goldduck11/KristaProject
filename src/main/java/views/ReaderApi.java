package views;

import controllers.Facade;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/read")
@Produces(MediaType.APPLICATION_JSON)
public class ReaderApi {
    private final Facade facade = new Facade("mongo");

    @GET
    @Path("/categories")
    public Response getAllCategories() {
        return Response.status(Response.Status.OK)
                .entity(facade.getCategoryController().getAllCategories())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/categories/{uuid}")
    public Response getCategoryById(@PathParam("uuid") UUID uuid) {
        return Response.status(Response.Status.OK)
                .entity(facade.getCategoryController().getCategoryById(uuid))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/news")
    public Response getAllNews() {
        return Response.status(Response.Status.OK)
                .entity(facade.getNewsController().getAllNews())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/news/get/{uuid}")
    public Response getNewsById(@PathParam("uuid") UUID uuid) {
        return Response.status(Response.Status.OK)
                .entity(facade.getNewsController().getNewsById(uuid))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
