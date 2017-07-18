package com.cl.boot;


import jersey.repackaged.com.google.common.collect.ImmutableMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * Created by MrC on 2017/6/20
 */
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    private static final int requestStatus = 1000000;

    public Response toResponse(Throwable exception) {
        exception.printStackTrace();
        if (exception instanceof BusinessException) {
            BusinessException businessException = (BusinessException) exception;
            return Response.status(requestStatus).entity(ImmutableMap.<String, Object>of(
                    "code", businessException.getCode(),
                    "message", businessException.getMessage()
            )).build();
        } else {
            return Response.status(getStatus(exception))
                    .entity(ImmutableMap.<String, Object>of(
                            "code", getStatus(exception),
                            "message", Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase()
                    )).build();
        }
    }

    private int getStatus(Throwable ex) {
        if (ex instanceof WebApplicationException) {
            return ((WebApplicationException) ex).getResponse().getStatus();
        } else {
            return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
        }
    }
}
