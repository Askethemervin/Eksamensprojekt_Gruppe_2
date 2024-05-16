package com.example.eksamenprojekt_gruppe_2.Service;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Repository.DamageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DamageReportService {

    private final DamageReportRepository damageReportRepository;

    @Autowired
    public DamageReportService(DamageReportRepository damageReportRepository) {
        this.damageReportRepository = damageReportRepository;
    }

    public void saveDamageReport(DamageReport damageReport) {
        damageReportRepository.save(damageReport);
    }

    public DamageReport getDamageReportById(int id) {
        return damageReportRepository.findById(id);
    }

    public void updateDamageReport(DamageReport damageReport) {
        damageReportRepository.update(damageReport);
    }

    public void deleteDamageReportById(int id) {
        damageReportRepository.deleteById(id);
    }
}
