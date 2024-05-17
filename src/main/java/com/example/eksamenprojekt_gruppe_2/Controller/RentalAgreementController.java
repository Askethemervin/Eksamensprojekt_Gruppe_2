package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
import com.example.eksamenprojekt_gruppe_2.Service.CarService;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;
    @Autowired
    private CarService carService;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;
    @GetMapping("/CreateRentalAgreementForm")
    public String CreateRentalAgreementForm() {
        return "rentalAgreementForm";
    }

    @PostMapping("/addRentalAgreement")
    public ResponseEntity<Map<String, String>> addRentalAgreement(@RequestParam("rental_type") String rental_type, @RequestParam("duration") int duration, @RequestParam("price") double price, @RequestParam("car_id") int car_id) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setRental_type(rental_type);
        rentalAgreement.setDuration(duration);
        rentalAgreement.setPrice(price);
        rentalAgreement.setCar_id(car_id);


        try{
            rentalAgreementRepository.addRentalAgreement(rentalAgreement);
            carService.updateCarStatus(car_id, "rented");
            return ResponseEntity.ok().body(Map.of("message","Rental Agreement has been added."));
        }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","An error has occured while making your rental agreement"));
        }


    }
    @GetMapping("/showRentalAgreement")
    public String showRentalAgreement(Model model) {
        List<RentalAgreement> rentalAgreements = rentalAgreementService.getAllRentalAgreements();
        model.addAttribute("rentalAgreements", rentalAgreements);
        return "rentalAgreementDashboard";
    }

}
