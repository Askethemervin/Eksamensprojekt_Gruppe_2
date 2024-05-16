package com.example.eksamenprojekt_gruppe_2.Service;


import com.example.eksamenprojekt_gruppe_2.Model.Damages;
import com.example.eksamenprojekt_gruppe_2.Repository.DamagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamagesService {

    private DamagesRepository damagesRepository;

    @Autowired
    public DamagesService(DamagesRepository damagesRepository) {
        this.damagesRepository = damagesRepository;
    }

    public void saveDamage (Damages damage) {
        damagesRepository.save(damage);
    }

    public Damages getDamageById (int id) {
        return damagesRepository.findById(id);
    }

    public void updateDamageReport(Damages damage) {
        damagesRepository.update(damage);
    }
    public void deleteDamageById (int id) {
        damagesRepository.deleteById(id);
    }

    public List<Damages> getAllDamages() {
        return damagesRepository.findAll();
    }
}
