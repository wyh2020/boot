package com.cl.boot;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * Created by MrC on 2017/6/20
 */
public class JerseyConfig extends ResourceConfig{
    public JerseyConfig(){
        register(JacksonFeature.class);
        register(GenericExceptionMapper.class);
        register(GenericResponseFilter.class);
        packages("com.cl.boot.resource");
    }
}
