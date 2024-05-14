package com.example.eksamenprojekt_gruppe_2.Model;

public class Car {
    int vehicleNumber;
    String model;
    int serialNumber;
    String licensePlate;
    String brand;
    String status;
    char enviromentlabel;
    int year;

    public Car(){

    }

    public Car(String model, int serialNumber, String licensePlate, String brand, String status, char enviromentlabel, int year) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.status = status;
        this.enviromentlabel = enviromentlabel;
        this.year = year;
    }

    public Car(int vehicleNumber, String model, int serialNumber, String licensePlate, String brand, String status, char enviromentlabel, int year) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.serialNumber = serialNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.status = status;
        this.enviromentlabel = enviromentlabel;
        this.year = year;
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char getEnviromentlabel() {
        return enviromentlabel;
    }

    public void setEnviromentlabel(char enviromentlabel) {
        this.enviromentlabel = enviromentlabel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
