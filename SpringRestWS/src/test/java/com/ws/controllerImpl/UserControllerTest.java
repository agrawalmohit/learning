package com.ws.controllerImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;


import static org.mockito.Mockito.*;

import com.ws.pojo.UserPojo;
import com.ws.serviceIntf.UserServiceIntf;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    
    @Mock
    private UserServiceIntf userService;
    
    @InjectMocks
    private UserControllerImpl userController;
    
    @Test
    public void createUserTest(){
        UserPojo user1 = new UserPojo();
        user1.setUserName("TestUser1");
        user1.setEmailId("test@test.com");
        UserPojo user2 = new UserPojo();
        user2.setUserName("TestUser1");
        user2.setEmailId("test@test.com");
        user2.setUserId(new Integer(1));
        when(userService.createUser(user1)).thenReturn(user2);
        UserPojo user3 = userController.createUser(user1);
        verify(userService, times(1)).createUser(user1);
        Assert.assertEquals(user2.getUserId(), user3.getUserId());
    }
}
