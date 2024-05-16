package com.example.eksamenprojekt_gruppe_2.Model;

public class RentalAgreement {
    int id;
    String rental_type;
    int duration;


    double price;
    int car_id;

    public RentalAgreement(){
    }

    public RentalAgreement(String rental_type, int duration, double price, int car_id){
        this.rental_type = rental_type;
        this.duration = duration;
        this.price = price;
        this.car_id = car_id;
    }
    public RentalAgreement(int id, String rental_type, int duration, double price, int car_id) {
        this.id = id;
        this.rental_type = rental_type;
        this.duration = duration;
        this.price = price;
        this.car_id = car_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRental_type() {
        return rental_type;
    }

    public void setRental_type(String rental_type) {
        this.rental_type = rental_type;
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
    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

}
