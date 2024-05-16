package com.example.eksamenprojekt_gruppe_2.Model;

public class Customer {
    int customer_id;
    String first_name;
    String last_name;
    int driverslicense_number;
    int rental_id;

    public Customer() {
    }

    public Customer(String first_name, int rental_id, int driverslicense_number, String last_name) {
        this.first_name = first_name;
        this.rental_id = rental_id;
        this.driverslicense_number = driverslicense_number;
        this.last_name = last_name;
    }

    public Customer(int customer_id, String last_name, String first_name, int driverslicense_number, int rental_id) {
        this.customer_id = customer_id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.driverslicense_number = driverslicense_number;
        this.rental_id = rental_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDriverslicense_number() {
        return driverslicense_number;
    }

    public void setDriverslicense_number(int driverslicense_number) {
        this.driverslicense_number = driverslicense_number;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }
}
