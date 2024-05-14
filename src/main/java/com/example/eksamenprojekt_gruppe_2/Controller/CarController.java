package com.example.eksamenprojekt_gruppe_2.Controller;

import org.springframework.ui.Model;
import com.example.eksamenprojekt_gruppe_2.Model.Car;
import com.example.eksamenprojekt_gruppe_2.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/biler")
    public String showCars(Model model){
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "Car";
    }
}