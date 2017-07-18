package com.cl.boot.api;

import com.cl.boot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService
 * Created by MrC on 2017/6/20
 */
@Service
public interface UserService {

    String sayHello();

    User getUser();

    @Transactional
    void editUsers() throws Exception;
}
