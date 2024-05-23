package com.OnlineApplicationProject.Service.impl;

import com.OnlineApplicationProject.Repository.UserRepo;
import com.OnlineApplicationProject.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
   private UserRepo userRepo;

    public User RegisterUser(User user){
     User saveuser= userRepo.save(user);
     return saveuser;
    }

    public User loginuser(String email,String password){
         return userRepo.User_login(email,password);
    }

}
