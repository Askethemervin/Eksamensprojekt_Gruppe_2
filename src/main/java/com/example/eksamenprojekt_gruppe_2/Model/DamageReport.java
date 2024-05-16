package com.example.eksamenprojekt_gruppe_2.Model;

public class DamageReport {
    private int id;
    private int rentalAgreementId;

    public DamageReport () {
    }

    public DamageReport(int id, int rentalAgreementId) {
        this.id = id;
        this.rentalAgreementId = rentalAgreementId;
    }

    public DamageReport(int rentalAgreementId) {
        this.rentalAgreementId = rentalAgreementId;
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
}
