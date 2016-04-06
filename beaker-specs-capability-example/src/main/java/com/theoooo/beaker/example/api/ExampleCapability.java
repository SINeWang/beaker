package com.theoooo.beaker.example.api;

import com.theoooo.beaker.example.exception.ExampleException;
import com.theoooo.beaker.example.model.ExampleForm;
import com.theoooo.beaker.example.model.ExampleView;
import com.theoooo.beaker.specs.model.CapabilityException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by WangYanJiong on 4/3/16.
 */

@Path("/examples")
@Produces(MediaType.APPLICATION_JSON)
public interface ExampleCapability {

    /**
     * Exception Code
     */
    enum EC{
        name_is_null,
        password_is_null
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    ExampleView createExample(ExampleForm form) throws ExampleException;

    @GET
    @Path("/")
    List<ExampleView> queryExamples(@QueryParam("key") String key, @QueryParam("value") String value, @QueryParam("page") int page, @QueryParam("size") int size) throws CapabilityException;

    @GET
    @Path("/{exampleId}")
    ExampleView findExample(@QueryParam("exampleId") String exampleId) throws CapabilityException;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{exampleId}")
    ExampleView updateExample(ExampleForm form) throws CapabilityException;

    @DELETE
    @Path("/{exampleId}")
    ExampleView deleteExample(@PathParam("exampleId") String exampleId) throws CapabilityException;

    @HEAD
    @Path("/{exampleId}")
    ExampleView getExampleStatus(@QueryParam("exampleId") String exampleId) throws CapabilityException;

}
