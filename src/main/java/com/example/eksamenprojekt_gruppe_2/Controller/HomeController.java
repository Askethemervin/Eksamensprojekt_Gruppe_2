package dk.kea.projektgruppe_3_full_stack_new.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.User;
import com.example.eksamenprojekt_gruppe_2.Repository.DatabaseManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

}