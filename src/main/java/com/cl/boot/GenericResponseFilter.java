package com.cl.boot;

import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GenericResponseFilter implements ContainerResponseFilter {

    private static final int requestStatus = 1000000;

    private Object formerEntity;

    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {


        MultivaluedMap<String, Object> headers = responseContext.getHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type," +
                " Accept, Accept-Encoding,Accept-Language, Cache-Control, Connection, " +
                "Content-Length, Host, Origin, No-Cache,Expires, User-Agent,accessToken");
        this.formerEntity = responseContext.getEntity();
        String path = requestContext.getUriInfo().getPath();
        if (path.contains("swagger")) {
            return;
        }
        if (200 == responseContext.getStatus()) {
            if ("GET".equals(requestContext.getMethod())) {
                Map<String, Object> result = new HashMap<String, Object>();
                result.put("code", 0);
                result.put("message", "ok");
                result.put("data", responseContext.getEntity());
                responseContext.setEntity(result, null, MediaType.APPLICATION_JSON_TYPE);
            } else {
                if (null == responseContext.getEntity()) {
                    responseContext.setEntity(ImmutableMap.<String, Object>of(
                            "code", 0,
                            "message", "ok"
                    ), null, MediaType.APPLICATION_JSON_TYPE);
                } else {
                    responseContext.setEntity(ImmutableMap.<String, Object>of(
                            "code", 0,
                            "message", "ok",
                            "data", responseContext.getEntity()
                    ), null, MediaType.APPLICATION_JSON_TYPE);
                }
            }
        } else if (requestStatus == responseContext.getStatus()) {
            responseContext.setStatus(Response.Status.OK.getStatusCode());
        } else if (404 == responseContext.getStatus()) {
            responseContext.setEntity(ImmutableMap.<String, Object>of(
                    "code", 404,
                    "message", "resource not found."
            ), null, MediaType.APPLICATION_JSON_TYPE);
        } else if (400 == responseContext.getStatus()) {
            responseContext.setEntity(ImmutableMap.<String, Object>of(
                    "code", 400,
                    "message", "bad request"
            ), null, MediaType.APPLICATION_JSON_TYPE);
        } else {
            responseContext.setEntity(ImmutableMap.<String, Object>of(
                    "code", responseContext.getStatus(),
                    "message", "server internal  error"
            ), null, MediaType.APPLICATION_JSON_TYPE);
        }
    }
    public Object getFormerEntity() {
        return formerEntity;
    }

    public void setFormerEntity(Object formerEntity) {
        this.formerEntity = formerEntity;
    }
}