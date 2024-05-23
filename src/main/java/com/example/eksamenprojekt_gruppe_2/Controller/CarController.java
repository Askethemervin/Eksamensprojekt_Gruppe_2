package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Service.RentalAgreementService;
import org.springframework.ui.Model;
import com.example.eksamenprojekt_gruppe_2.Model.Car;
import com.example.eksamenprojekt_gruppe_2.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // Viser en liste over alle biler
    @GetMapping("/biler")
    public String showCars(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "Car";
    }

    // Viser en liste over udlejede biler sammen med deres lejeaftaler og total lejepris
    @GetMapping("/Udlejedebiler")
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

    // Viser en liste over returnerede biler og antal returnerede biler
    @GetMapping("/returneredebiler")
    public String showReturnedCars(Model model) {
        List<Car> returnedCars = carService.getCarsByStatusReturned();
        List<RentalAgreement> rentalAgreements = rentalAgreementService.getAllRentalAgreements();

        Map<Integer, RentalAgreement> rentalMap = rentalAgreements.stream()
                .collect(Collectors.toMap(RentalAgreement::getCar_id, ra -> ra));

        int returnedCarsCount = returnedCars.size();

        model.addAttribute("cars", returnedCars);
        model.addAttribute("rentalMap", rentalMap);
        model.addAttribute("returnedCarsCount", returnedCarsCount);
        return "ReturnedCars";
    }

    // Opdaterer status for en bil til "returneret" og omdirigerer til siden med returnerede biler
    @PostMapping ("/returnCar")
    public String returnCar(@RequestParam("carId") int carId){
    carService.updateCarStatusReturned(carId);
    return "redirect:/returneredebiler";
    }

    // Opdaterer status for en bil til "tilgængelig" og omdirigerer til siden med returnerede biler
    @PostMapping("/makeCarAvailable")
    public String makeCarAvailable(@RequestParam("carId") int carId){
        rentalAgreementService.deleteRentalAgreementByCarId(carId);
        carService.updateCarStatusAvailable(carId);
        return "redirect:/returneredebiler";
    }

    // Opdaterer status for en bil til "klar til salg" og omdirigerer til siden med returnerede biler
    @PostMapping("/makeCarReadyForSale")
    public String makeCarReadyForSale(@RequestParam("carId") int carId){
        rentalAgreementService.deleteRentalAgreementByCarId(carId);
        carService.updateCarStatusReadyForSale(carId);
        return "redirect:/returneredebiler";
    }

}