package com.theoooo.beaker.example.api;



import com.theoooo.beaker.example.model.SampleForm;
import com.theoooo.beaker.example.model.SampleView;
import com.theoooo.beaker.example.exception.SampleException;
import com.theoooo.beaker.specs.model.CapabilityException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by WangYanJiong on 4/3/16.
 */

@Path("/examples")
@Produces(MediaType.APPLICATION_JSON)
public interface SampleCapability {

    enum EC{
        name_is_null,
        password_is_null
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    SampleView createSample(SampleForm form) throws SampleException;

    @GET
    @Path("/")
    List<SampleView> querySamples(@QueryParam("key") String key, @QueryParam("value") String value, @QueryParam("page") int page, @QueryParam("size") int size) throws CapabilityException;

    @GET
    @Path("/{sampleId}")
    SampleView findSample(@QueryParam("sampleId") String exampleId) throws CapabilityException;

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{sampleId}")
    SampleView updateSample(SampleForm form) throws SampleException;

    @DELETE
    @Path("/{sampleId}")
    SampleView deleteSample(@PathParam("sampleId") String exampleId) throws CapabilityException;

    @HEAD
    @Path("/{sampleId}")
    SampleView getSampleStatus(@QueryParam("sampleId") String exampleId) throws CapabilityException;

}
