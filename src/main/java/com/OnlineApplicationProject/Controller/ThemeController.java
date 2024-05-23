package com.OnlineApplicationProject.Controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThemeController {

    @PostMapping("/update-theme")
    public void updateTheme(String theme, HttpServletResponse response, Model model) {
        Cookie themeCookie = new Cookie("theme", theme);
        themeCookie.setMaxAge(30 * 24 * 60 * 60);
        themeCookie.setPath("/*");
        response.addCookie(themeCookie);
        model.addAttribute(themeCookie);
     }
}
