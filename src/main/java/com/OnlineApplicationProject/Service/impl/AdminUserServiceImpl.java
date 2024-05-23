package com.OnlineApplicationProject.Service.impl;

import com.OnlineApplicationProject.Repository.AdminUserRepo;
import com.OnlineApplicationProject.Entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl {
    @Autowired
    private AdminUserRepo adminUserRepo;
    public AdminUser RegisterUser(AdminUser user){
        AdminUser saveuser= adminUserRepo.save(user);
        return saveuser;
    }
    public AdminUser loginuseradmin(String email,String password){
        return adminUserRepo.admin_login(email,password);
    }

}
