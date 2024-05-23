package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
import com.example.eksamenprojekt_gruppe_2.Service.CarService;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;
    @Autowired
    private CarService carService;
    @Autowired
    private RentalAgreementRepository rentalAgreementRepository;

    // Viser formularen til at oprette en ny lejeaftale
    @GetMapping("/Opretnylejeaftale")
    public String CreateRentalAgreementForm() {
        return "rentalAgreementForm";
    }

    // Håndterer indsendelsen af en ny lejeaftale og opdaterer bilens status til "rented"
    @PostMapping("/addRentalAgreement")
    public RedirectView addRentalAgreement(@RequestParam("rental_type") String rental_type, @RequestParam("duration") int duration, @RequestParam("price") double price, @RequestParam("car_id") int car_id, @RequestParam("customer_id") int customer_id) {
        RentalAgreement rentalAgreement = new RentalAgreement();
        rentalAgreement.setRental_type(rental_type);
        rentalAgreement.setDuration(duration);
        rentalAgreement.setPrice(price);
        rentalAgreement.setCar_id(car_id);
        rentalAgreement.setCustomer_id(customer_id);

        try {
            // Tilføjer lejeaftalen til databasen og opdaterer bilens status til "rented"
            rentalAgreementRepository.addRentalAgreement(rentalAgreement);
            carService.updateCarStatus(car_id, "rented");
            return new RedirectView("/vislejeaftaler");
        } catch (Exception e) {
            // Logger fejlen og omdirigerer til formularen med en fejlbesked
            System.out.println(e.getMessage());
            e.printStackTrace();
            RedirectView redirectView = new RedirectView("/CreateRentalAgreementForm");
            redirectView.addStaticAttribute("error", "An error has occurred while making your rental agreement");
            return redirectView;
        }
    }

    // Viser alle lejeaftaler i et dashboard
    @GetMapping("/vislejeaftaler")
    public String showRentalAgreement(Model model) {
        List<RentalAgreement> rentalAgreements = rentalAgreementService.getAllRentalAgreements();
        model.addAttribute("rentalAgreements", rentalAgreements);
        return "rentalAgreementDashboard";
    }
}
