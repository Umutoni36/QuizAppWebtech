package com.OnlineApplicationProject.Controller;

import com.OnlineApplicationProject.Service.impl.AdminUserServiceImpl;
import com.OnlineApplicationProject.Entity.AdminUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired private AdminUserServiceImpl adminUserServiceImpl;

    @PostMapping("/adminLogin")
    private String adminLogin(@RequestParam String email, @RequestParam String password, HttpSession session){
        AdminUser feadback= adminUserServiceImpl.loginuseradmin(email,password);
        if(feadback !=null){
            session.setAttribute("loggedInAdmin",feadback.getId());
            return "redirect:/Project/AdminUI.jsp";
        }else{
            return "redirect:/Project/AdminAuthentication.jsp";
        }


    }
}
