package com.stackroute.service;

import com.stackroute.model.UserInformation;

public interface userService {

    public UserInformation populateUser(String username, String password);
}
