package com.ws.controllerIntf;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ws.pojo.UserPojo;

@RestController
@RequestMapping("/user")
public interface UserControllerIntf {
    
    
    @RequestMapping(path="/create", method=RequestMethod.POST)
    public UserPojo createUser(@RequestBody UserPojo user);
}
