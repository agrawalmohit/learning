package com.ws.serviceImpl;

import com.ws.pojo.UserPojo;
import com.ws.serviceIntf.UserServiceIntf;

public class UserServiceImpl implements UserServiceIntf{
    
    @Override
    public UserPojo createUser(UserPojo user) {
        user.setUserId(new Integer(1));
        return user;
    }
}
