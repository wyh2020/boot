package com.cl.boot.api;

import com.cl.boot.model.User;

/**
 * UserService
 * Created by MrC on 2017/6/20
 */
public interface UserService {

    String sayHello();

    User getUser();

    void editUsers() throws RuntimeException;
}
