package com.stackroute.service;

import com.stackroute.controller.UserController;
import com.stackroute.model.UserInformation;

public class userServiceImp implements userService{

    @Override
    public UserInformation populateUser(String username, String password) {
            UserInformation userInformation = new UserInformation();
            userInformation.setUsername(username);
            userInformation.setPassword(password);
            return userInformation;
    }
}
