package com.cl.boot.resource;

import com.cl.boot.api.UserService;
import com.cl.boot.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
@Api(value = "user",description = "用户接口")
public class UserResource {

    @Autowired
    private UserService userService;

    @GET
    @Path("user")
    @ApiOperation(value = "获取用户信息",httpMethod = "GET")
    @ApiResponse(code = 200,message = "ok")
    public Response user() {
        User user = userService.getUser();
        return Response.ok(user).build();
    }

    @POST
    @Path("editUser")
    public Response editUser() throws Exception {
        userService.editUsers();
        return Response.ok("1111111111111111111111").build();
    }
}
