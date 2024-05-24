package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {

    private DamageRepository damageRepository;

    @Autowired
    public DamageService(DamageRepository damageRepository) {
        this.damageRepository = damageRepository;
    }

    // Gemmer en skadesrapport ved at kalde save-metoden i DamageRepository
    public void saveDamageReport (DamageReport damageReport) {
        damageRepository.save(damageReport);
    }

    public void deleteDamageReportsByRentalAgreementId(int lejeaftale_id) {
        damageRepository.deleteByRentalAgreementId(lejeaftale_id);
    }
}
