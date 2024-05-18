package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.ui.Model;
import com.example.eksamenprojekt_gruppe_2.Model.Car;
import com.example.eksamenprojekt_gruppe_2.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class CarController {

    private final CarService carService;
    private final RentalAgreementService rentalAgreementService;
    @Autowired
    public CarController(CarService carService, RentalAgreementService rentalAgreementService) {
        this.carService = carService;
        this.rentalAgreementService=rentalAgreementService;
    }


    @GetMapping("/cars")
    public String showCars(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "Car";
    }

    @GetMapping("/RentedCars")
    public String showRentedCars(Model model){
        List<Car> cars = carService.getCarsbyStatusRented();
        List<RentalAgreement> rentalAgreements = rentalAgreementService.getAllRentalAgreements();

        Map<Integer, RentalAgreement> rentalMap = rentalAgreements.stream()
                .collect(Collectors.toMap(RentalAgreement::getCar_id, ra -> ra));

        double totalRentalPrice = cars.stream()
                .filter(car -> rentalMap.containsKey(car.getVehicleNumber()))
                .mapToDouble(car -> rentalMap.get(car.getVehicleNumber()).getPrice())
                .sum();

        int rentedcarsCount = cars.size();

        model.addAttribute("cars", cars);
        model.addAttribute("rentalMap", rentalMap);
        model.addAttribute("totalRentalPrice", totalRentalPrice);
        model.addAttribute("rentedcarsCount", rentedcarsCount);
        return "RentedCars";

    }
}