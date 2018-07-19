package com.ws.serviceIntf;

import org.springframework.stereotype.Service;

import com.ws.pojo.UserPojo;

@Service
public interface UserServiceIntf {
    
    public UserPojo createUser(UserPojo user);
    
}
