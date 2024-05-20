package com.example.eksamenprojekt_gruppe_2.Model;

public class DamageReport {
    private int id;
    private int rentalAgreementId;
    private String damageDescription;
    private double price;

    public DamageReport() {
    }

    public DamageReport(int rentalAgreementId, String damageDescription, double price) {
        this.rentalAgreementId=rentalAgreementId;
        this.damageDescription=damageDescription;
        this.price=price;
    }

    public DamageReport(int id, int rentalAgreementId, String damageDescription, double price) {
        this.id = id;
        this.rentalAgreementId=rentalAgreementId;
        this.damageDescription=damageDescription;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRentalAgreementId() {
        return rentalAgreementId;
    }

    public void setRentalAgreementId(int rentalAgreementId) {
        this.rentalAgreementId = rentalAgreementId;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
