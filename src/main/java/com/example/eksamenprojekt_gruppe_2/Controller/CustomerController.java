package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.Customer;
import com.example.eksamenprojekt_gruppe_2.Repository.CustomerRepository;
import com.example.eksamenprojekt_gruppe_2.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/CreateCustomer")
    public String CreateCustomer(){
        return "CreateCustomer";
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Map<String,String>> addCustomer(@RequestParam("first_name") String first_name,@RequestParam("last_name") String last_name,@RequestParam("driverslicense_number") int driverslicense_number){
        Customer customer =new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setDriverslicense_number(driverslicense_number);

        try {
            customerRepository.addCustomer(customer);
            return ResponseEntity.ok().body(Map.of("message","The customer has been added"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","An error has occured while adding the customer."));
        }
    }


}
