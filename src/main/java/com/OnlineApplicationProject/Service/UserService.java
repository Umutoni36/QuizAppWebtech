package com.OnlineApplicationProject.Service;

import com.OnlineApplicationProject.Entity.User;

public interface UserService {

    User RegisterUser(User user);

    User loginuser(String email,String password);
}
