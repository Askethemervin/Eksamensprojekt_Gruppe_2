package com.example.eksamenprojekt_gruppe_2.Model;

public class RentalAgreement {
    int id;
    int type;
    int duration;
    int price;

    public RentalAgreement(){

    }
    public RentalAgreement(int type, int duration, int price){
        this.type = type;
        this.duration = duration;
        this.price = price;
    }
    public RentalAgreement(int id, int type, int duration, int price) {
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
