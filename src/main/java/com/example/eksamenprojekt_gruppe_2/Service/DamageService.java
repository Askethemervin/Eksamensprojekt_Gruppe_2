package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageService {

    @Autowired
    private DamageRepository damageRepository;

    public void saveDamageReport (DamageReport damageReport) {
        damageRepository.save(damageReport);
    }

    public DamageReport getDamageReportById (int id) {
        return damageRepository.findById(id);
    }

    public void updateDamageReport(DamageReport damageReport) {
        damageRepository.update(damageReport);
    }
    public void deleteDamageReportById (int id) {
        damageRepository.deleteById(id);
    }

    public List<DamageReport> getAllDamageReports() {
        return damageRepository.findAll();
    }
}
