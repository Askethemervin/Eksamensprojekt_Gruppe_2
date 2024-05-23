package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.Car;
import com.example.eksamenprojekt_gruppe_2.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // Henter alle biler fra repository
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // Henter alle biler, der er udlejet, fra repository
    public List<Car> getCarsbyStatusRented(){
        return carRepository.findRentedCars();
    }

    // Henter alle biler, der er returneret, fra repository
    public List<Car> getCarsByStatusReturned(){
        return carRepository.findReturnedCars();
    }

    // Opdaterer status for en given bil i repository
    public void updateCarStatus(int carId, String status) {
        carRepository.updateCarStatus(carId, status);
    }

    // Opdaterer status for en given bil til "returneret" i repository
    public void updateCarStatusReturned(int carId) {
        carRepository.updateCarStatus(carId, "returned");
    }

    // Opdaterer status for en given bil til "ledig" i repository
    public void updateCarStatusAvailable(int carId) {
        carRepository.updateCarStatus(carId, "available");
    }

    // Opdaterer status for en given bil til "klar til salg" i repository
    public void updateCarStatusReadyForSale(int carId) {
        carRepository.updateCarStatus(carId,"ready for sale");
    }


}