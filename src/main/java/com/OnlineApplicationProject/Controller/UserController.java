package com.OnlineApplicationProject.Controller;

import com.OnlineApplicationProject.Service.impl.UserServiceImpl;
import com.OnlineApplicationProject.Entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
@Autowired private UserServiceImpl userServiceImpl;

////////Sign Up

@PostMapping("/signup")
    private String usersignup( User user){

    userServiceImpl.RegisterUser(user);
    return "redirect:/Project/Signup.jsp";
}

///////Login fanction/////////////////////
@PostMapping("/login")
private String userLogin(@RequestParam String email, @RequestParam String password, HttpSession session, @RequestParam(required = false) boolean rememberMe, HttpServletResponse response ){
    User feadback= userServiceImpl.loginuser(email,password);
    if(feadback !=null){
        session.setAttribute("userid",feadback.getId());
        session.setAttribute("useremail",feadback.getEmail());
        session.setAttribute("loggedInUser",true);

        if (rememberMe) {

            Cookie cookie = new Cookie("rememberMe", email + ":" + password);
            cookie.setMaxAge(600);; // Cookie expires in 10 i
            cookie.setPath("/"); // Set cookie path
            response.addCookie(cookie);
            System.out.println("The cookies "+cookie);

        }
        return "redirect:/Userquiz_form";
    }else{
        return "redirect:/Project/index.jsp";
    }
}

    @GetMapping("/logout")
    private String userLogout(HttpSession session){

             session.invalidate();

            return "redirect:/Project/index.jsp";

    }

}
