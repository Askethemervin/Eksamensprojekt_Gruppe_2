package com.example.eksamenprojekt_gruppe_2.Controller;

import com.azure.core.annotation.Get;
import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skadesrapporter")
public class DamageController {

    @Autowired
    private DamageService damageService;

    @PostMapping
    public void createDamageDefect(@RequestBody DamageReport damageReport) {
        damageService.saveDamageReport(damageReport);
    }

    @GetMapping("/{id}")
    public DamageReport getDamageReport(@PathVariable int id) {
        return damageService.getDamageReportById(id);
    }

    @PutMapping("/{id}")
    public void updateDamageDefect(@PathVariable int id, @RequestBody DamageReport damageReport) {
        damageReport.setId(id);
        damageService.updateDamageReport(damageReport);
    }

    @DeleteMapping("/{id}")
    public void deleteDamageReport(@PathVariable int id) {
        damageService.deleteDamageReportById(id);
    }

    @GetMapping
    public List<DamageReport> getAllDamageReports() {
        return damageService.getAllDamageReports();
    }
}
