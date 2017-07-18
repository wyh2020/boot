package com.cl.boot.resource;

import com.cl.boot.api.UserService;
import com.cl.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * user
 * Created by MrC on 2017/6/20
 */
@Path("user")
@Produces({MediaType.APPLICATION_JSON})
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @Path("user")
    public Response user() {
        User user = userService.getUser();
        return Response.ok(user).build();
    }

    @GET
    @Path("editUser")
    public Response editUser() throws Exception{
        userService.editUsers();
        return Response.ok().build();
    }
}
