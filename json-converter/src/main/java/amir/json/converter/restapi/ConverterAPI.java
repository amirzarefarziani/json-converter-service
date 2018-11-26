package amir.json.converter.restapi;

import amir.json.converter.service.JsonGeneratorService;
import amir.json.converter.service.ObjectConstructorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ConverterAPI")
public class ConverterAPI {

    private final ObjectConstructorService objectConstructorService;
    private final JsonGeneratorService jsonGeneratorService;

    private static final String EXCEPTION_CAUGHT = "exception caught: ";
    private static final Logger logger = LoggerFactory.getLogger(ConverterAPI.class);

    @Inject
    public ConverterAPI(ObjectConstructorService objectConstructorService, JsonGeneratorService jsonGeneratorService) {
        this.objectConstructorService = objectConstructorService;
        this.jsonGeneratorService = jsonGeneratorService;
    }

    @POST
    @Path("/json/convertByObjectConstructor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertByObjectConstructor(String json) {
        try {
            return Response
                    .ok(objectConstructorService.convertByObjectConstructor(json))
                    .build();
        } catch (Exception e) {
            logger.error(EXCEPTION_CAUGHT, e);
            return Response.ok(Entity.json(e)).build();
        }
    }

    @POST
    @Path("/json/convertByJsonGenerator")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertByJsonGenerator(String json) {
        try {
            return Response
                    .ok(jsonGeneratorService.convertByJsonGenerator(json).toString())
                    .build();
        } catch (Exception e) {
            logger.error(EXCEPTION_CAUGHT, e);
            return Response.ok(Entity.json(e)).build();
        }
    }

    @POST
    @Path("/bulk-json/convertByObjectConstructor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertBulkByObjectConstructor(String json) {
        try {
            objectConstructorService.convertByObjectConstructor(json);
            return Response
                    .ok(Entity.json("done"))
                    .build();
        } catch (Exception e) {
            logger.error(EXCEPTION_CAUGHT, e);
            return Response.ok(Entity.json(e)).build();
        }
    }

    @POST
    @Path("/bulk-json/convertByJsonGenerator")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response convertBulkJsonByJsonGenerator(String json) {
        try {
            jsonGeneratorService.convertByJsonGenerator(json);
            return Response
                    .ok(Entity.json("done"))
                    .build();
        } catch (Exception e) {
            logger.error(EXCEPTION_CAUGHT, e);
            return Response.ok(Entity.json(e)).build();
        }
    }

}
