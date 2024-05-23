package com.OnlineApplicationProject.Service;

import com.OnlineApplicationProject.Entity.AdminUser;

public interface AdminUserService {

    AdminUser RegisterUser(AdminUser user);

    AdminUser loginuseradmin(String email,String password);


}
