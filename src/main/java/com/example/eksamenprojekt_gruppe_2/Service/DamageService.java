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

    public void saveDamageReport (DamageReport damageReport) {
        damageRepository.save(damageReport);
    }

    public List<DamageReport> loadDamageReport(int lejeaftale_id) {
        return damageRepository.loadDamageReport(lejeaftale_id);
    }
}
