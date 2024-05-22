package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalAgreementService {

    private RentalAgreementRepository rentalAgreementRepository;
    @Autowired
    public RentalAgreementService(RentalAgreementRepository rentalAgreementRepository) {
        this.rentalAgreementRepository = rentalAgreementRepository;
    }
    public List<RentalAgreement> getAllRentalAgreements() {
        return rentalAgreementRepository.findAll();
    }

}
