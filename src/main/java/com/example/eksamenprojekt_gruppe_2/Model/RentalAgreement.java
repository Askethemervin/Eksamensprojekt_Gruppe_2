package com.example.eksamenprojekt_gruppe_2.Model;

public class RentalAgreement {
    int id;
    String rental_type;
    int duration;


    double price;
    int car_id;
    int customer_id;

    public RentalAgreement() {
    }

    public RentalAgreement(String rental_type, int car_id, int duration, double price, int customer_id) {
        this.rental_type = rental_type;
        this.car_id = car_id;
        this.duration = duration;
        this.price = price;
        this.customer_id = customer_id;
    }

    public RentalAgreement(String rental_type, int id, int duration, double price, int car_id, int customer_id) {
        this.rental_type = rental_type;
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.car_id = car_id;
        this.customer_id = customer_id;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}