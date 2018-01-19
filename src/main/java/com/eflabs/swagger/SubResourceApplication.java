package com.eflabs.swagger;

import com.eflabs.swagger.resource.v1.V1Router;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;

public class SubResourceApplication extends Application<Configuration> {

    public static void main(final String[] args) throws Exception {
        new SubResourceApplication().run(args);
    }

    @Override
    public String getName() {
        return "SubResource";
    }

    @Override
    public void initialize(final Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(final Configuration configuration, final Environment environment) {
        environment.jersey().register(V1Router.class);
        initSwagger(environment);
    }

    private void initSwagger(Environment environment) {
        environment.jersey().register(new ApiListingResource());

        BeanConfig config = new BeanConfig();
        config.setResourcePackage(V1Router.class.getPackage().getName());
        config.setScan(true);
    }

}
