package com.example.eksamenprojekt_gruppe_2.Model;

public class RentalAgreement {
    int id;
    String type;
    int duration;
    double price;

    public RentalAgreement(){
    }

    public RentalAgreement(String type, int duration, double price){
        this.type = type;
        this.duration = duration;
        this.price = price;
    }
    public RentalAgreement(int id, String type, int duration, double price) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.price = price;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
