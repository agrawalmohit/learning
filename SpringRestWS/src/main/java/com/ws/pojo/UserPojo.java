package com.ws.pojo;

public class UserPojo {
    
    private Integer userId;
    private String userName;
    private String emailId;
    
    public String getEmailId() {
        return emailId;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
}
