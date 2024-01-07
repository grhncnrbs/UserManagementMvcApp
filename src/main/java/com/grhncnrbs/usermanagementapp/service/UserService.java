package com.grhncnrbs.usermanagementapp.service;

import com.grhncnrbs.usermanagementapp.model.User;

public interface UserService {

    public User createUser(User user);

    public boolean checkEmail(String email);
}
