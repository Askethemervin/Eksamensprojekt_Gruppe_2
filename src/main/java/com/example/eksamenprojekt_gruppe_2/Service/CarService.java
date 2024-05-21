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

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    public List<Car> getCarsbyStatusRented(){
        return carRepository.findRentedCars();
    }
    public List<Car> getCarsByStatusReturned(){
        return carRepository.findReturnedCars();
    }
    public void updateCarStatus(int carId, String status) {

        carRepository.updateCarStatus(carId, status);
    }
    public void updateCarStatusReturned(int carId) {

        carRepository.updateCarStatus(carId, "returned");
    }
    public void updateCarStatusAvailable(int carId) {

        carRepository.updateCarStatus(carId, "available");
    }
    public void updateCarStatusReadyForSale(int carId) {
        carRepository.updateCarStatus(carId,"ready for sale");
    }


}