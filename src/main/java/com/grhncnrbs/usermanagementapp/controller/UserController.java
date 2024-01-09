package com.grhncnrbs.usermanagementapp.controller;

import com.grhncnrbs.usermanagementapp.model.User;
import com.grhncnrbs.usermanagementapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private void userDetails(Model model, Principal principal) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email);
        model.addAttribute("user", user);
    }

    @GetMapping("/")
    public String home() {
        return "user/home";
    }
}
