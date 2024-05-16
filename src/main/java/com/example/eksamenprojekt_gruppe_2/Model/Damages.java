package com.example.eksamenprojekt_gruppe_2.Model;

public class Damages {
    private int id;
    private int damageReportId;
    private String damageDescription;
    private double price;

    public Damages () {
    }

    public Damages(int damageReportId, String damageDescription, double price) {
        this.damageReportId = damageReportId;
        this.damageDescription = damageDescription;
        this.price = price;
    }

    public Damages(int id, int damageReportId, String damageDescription, double price) {
        this.id = id;
        this.damageReportId = damageReportId;
        this.damageDescription = damageDescription;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamageReportId() {
        return damageReportId;
    }

    public void setDamageReportId(int damageReportId) {
        this.damageReportId = damageReportId;
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
