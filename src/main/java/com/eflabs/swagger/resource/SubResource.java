package com.eflabs.swagger.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
@Api("this is a test sub resource")
// Swagger should ignore this path. The path is already defined in the parent for this class.
@Path("subresource")
public class SubResource {

    private final AtomicLong counter = new AtomicLong();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Get a simple hello world message")
    public String getHelloMessage() {
        return "Hello world! (" + counter.incrementAndGet() + ")";
    }

}
