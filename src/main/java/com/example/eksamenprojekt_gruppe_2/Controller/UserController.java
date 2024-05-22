package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "SelectProfile";
    }

}