package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;
    @GetMapping("/CreateRentalAgreementForm")
    public String CreateRentalAgreementForm() {
        return "rentalAgreementForm";
    }

    @PostMapping("/addRentalAgreement")
    public ResponseEntity<Map<String, String>> addRentalAgreement(@RequestParam("rental_type") String rental_type, @RequestParam("duration") int duration, @RequestParam("price") double price) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setType(rental_type);
        rentalAgreement.setDuration(duration);
        rentalAgreement.setPrice(price);


        try{
            rentalAgreementRepository.addRentalAgreement(rentalAgreement);
            return ResponseEntity.ok().body(Map.of("message","Rental Agreement has been added."));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","An error has occured while making your rental agreement"));
        }
    }

}
