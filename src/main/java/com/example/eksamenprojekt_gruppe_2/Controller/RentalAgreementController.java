package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/CreateRentalAgreementForm")
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;

    @PostMapping("/addRentalAgreement")
    public ResponseEntity<Map<String, String>> addRentalAgreement(@RequestParam String type, @RequestParam int duration, @RequestParam double price) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setType(type);
        rentalAgreement.setDuration(duration);
        rentalAgreement.setPrice(price);


        try{
            rentalAgreementRepository.addRentalAgreement(rentalAgreement);
            return ResponseEntity.ok().body(Map.of("message","Rental Agreement has been added."));
        }catch (Exception a) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","An error has occured while making your rental agreement"));
        }
    }

}
