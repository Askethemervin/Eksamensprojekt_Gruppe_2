package com.example.eksamenprojekt_gruppe_2.Model;

public class Car {
    int vehicleNumber;
    String model;
    int serialNumber;
    String licensePlate;
    String brand;
    String vehiclestatus;
    char enviromentlabel;
    int car_year;
    int rentalAgreementId;

    public Car(){
    }

    public Car(String model, int serialNumber, String licensePlate, String brand, String vehiclestatus, char enviromentlabel, int car_year) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.vehiclestatus = vehiclestatus;
        this.enviromentlabel = enviromentlabel;
        this.car_year = car_year;
    }

    public Car(int vehicleNumber, String model, int serialNumber, String licensePlate, String brand, String vehiclestatus, char enviromentlabel, int car_year) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.vehiclestatus = vehiclestatus;
        this.enviromentlabel = enviromentlabel;
        this.car_year = car_year;
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
    public String getVehiclestatus() {
        return vehiclestatus;
    }

    public void setVehiclestatus(String vehiclestatus) {
        this.vehiclestatus = vehiclestatus;
    }

    public char getEnviromentlabel() {
        return enviromentlabel;
    }

    public void setEnviromentlabel(char enviromentlabel) {
        this.enviromentlabel = enviromentlabel;
    }

    public int getCar_year() {
        return car_year;
    }

    public void setCar_year(int car_year) {
        this.car_year = car_year;
    }
}
