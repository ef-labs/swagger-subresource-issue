package com.eflabs.swagger.resource.v1;

import com.eflabs.swagger.resource.SubResource;
import io.swagger.annotations.Api;

import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@Path("v1")
@Api("this is a parent resource")
public class V1Router {
    @Path("parent")
    public Class<SubResource> getSubResource() {
        return SubResource.class;
    }
}
