package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.Customer;
import com.example.eksamenprojekt_gruppe_2.Repository.CustomerRepository;
import com.example.eksamenprojekt_gruppe_2.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    // Viser siden til at oprette en kunde
    @GetMapping("/Opretkunde")
    public String CreateCustomer(){
        return "CreateCustomer";
    }

    // Tilføjer en ny kunde til systemet
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,@RequestParam("driverslicense_number") String driverslicense_number, Model model){

        // Validerer, om driverslicense_number er tal
        try {
            int driversLicenseNumber = Integer.parseInt(driverslicense_number);
        } catch (NumberFormatException e) {
            // Håndterer fejl, hvis driverslicense_number ikke er tal
            model.addAttribute("validationError", "Indtast kun tal i kørekortsnummer.");
            return "CreateCustomer";
        }

        // Opretter et nyt Customer objekt og sætter attributter
        Customer customer = new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setDriverslicense_number(Integer.parseInt(driverslicense_number));

        try {
            // Forsøger at tilføje kunden til databasen via CustomerRepository
            customerRepository.addCustomer(customer);
            return "redirect:/kunder";
        } catch (Exception e) {
            // Logger fejlen og returnerer en fejlbesked hvis der opstår en fejl
            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("fejlbesked", "Indtast gyldigt input");
            return "CreateCustomer";
        }
    }
    //GetMapping som viser alle kunder
    @GetMapping("/kunder")
    public String showCustomers(Model model){
        List<Customer> customer = customerService.getAllCustomers();
        model.addAttribute("customer",customer);
        return "Customer";
    }


}
