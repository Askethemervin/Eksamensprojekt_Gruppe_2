package com.example.eksamenprojekt_gruppe_2.Model;

public class Car {
    int vehicleNumber;
    String model;
    int serialNumber;
    String licensePlate;
    String brand;

    public Car(){

    }
    public Car(int vehicleNumber, String model, int serialNumber, String licensePlate, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
