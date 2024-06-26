package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.Customer;
import com.example.eksamenprojekt_gruppe_2.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // henter alle kunder fra repository
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

}
