package com.grhncnrbs.usermanagementapp.controller;

import com.grhncnrbs.usermanagementapp.model.User;
import com.grhncnrbs.usermanagementapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/create-user")
    public String createUser(@ModelAttribute User user, HttpSession session) {
        boolean isExist = userService.checkEmail(user.getEmail());
        if (isExist) {
            session.setAttribute("msg", "Bu eposta hesabı zaten kullanımda.");
        } else {
            User createdUser = userService.createUser(user);
            if (createdUser != null) {
                session.setAttribute("msg", "Kayıt başarılı.");
            } else {
                session.setAttribute("msg", "Bir hata oluştu.");
            }
        }
        return "redirect:/register";
    }
}
