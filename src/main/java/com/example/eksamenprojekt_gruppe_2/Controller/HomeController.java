package com.example.eksamenprojekt_gruppe_2.Controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

@GetMapping("/")
    public String home() {
    return "Home";
}
}
