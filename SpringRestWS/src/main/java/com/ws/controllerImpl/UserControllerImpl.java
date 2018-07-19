package com.ws.controllerImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ws.controllerIntf.UserControllerIntf;
import com.ws.pojo.UserPojo;
import com.ws.serviceIntf.UserServiceIntf;

public class UserControllerImpl implements UserControllerIntf {
    
    @Autowired
    private UserServiceIntf userService;
    
    @Override
    public UserPojo createUser(UserPojo user) {
        
        return userService.createUser(user);
    }
}
