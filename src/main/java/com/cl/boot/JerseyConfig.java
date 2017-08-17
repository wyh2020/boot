package com.cl.boot;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.annotation.PostConstruct;

/**
 * Created by MrC on 2017/6/20
 */
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {

        register(JacksonFeature.class);
        register(GenericExceptionMapper.class);
        register(GenericResponseFilter.class);

        packages("com.cl.boot.resource");
    }

//    @PostConstruct
//    public void init() {
//        register(io.swagger.jaxrs.listing.ApiListingResource.class);
//        register(io.swagger.jaxrs.listing.AcceptHeaderApiListingResource.class);
//        register(io.swagger.jaxrs.listing.SwaggerSerializers.class);
//        register(com.cl.boot.Swagger2.class);
//    }


}
