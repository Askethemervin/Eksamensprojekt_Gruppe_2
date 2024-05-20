package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.User;
import com.example.eksamenprojekt_gruppe_2.Repository.DatabaseManager;

import com.example.eksamenprojekt_gruppe_2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

@GetMapping("/")
    public String home() {
    return "Home";
}
}

