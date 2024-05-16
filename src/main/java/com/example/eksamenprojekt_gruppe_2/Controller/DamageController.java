package com.example.eksamenprojekt_gruppe_2.Controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Post;
import org.springframework.ui.Model;
import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DamageController {

    @Autowired
    private DamageService damageService;

    @GetMapping("/skadesrapporter/dashboard")
    public String Showdashboard(Model model) {
        List<DamageReport> damageReports = damageService.getAllDamageReports();
        model.addAttribute("damageReports", damageReports);
        return "Dashboard_DamageReport";
    }

    @GetMapping("/skadesrapporter/indtastid")
    public String Showindtastid(Model model) {
        List<DamageReport> damageReports = damageService.getAllDamageReports();
        model.addAttribute("damageReports", damageReports);
        return "ID_Site_DamageReport";
    }

    @PostMapping("/skadesrapporter/indtastid")
    public String processIdInput(@RequestParam int lejeaftale_id, RedirectAttributes redirectAttributes) {
        System.out.println("Received lejeaftale_id: " + lejeaftale_id);
        redirectAttributes.addAttribute("lejeaftale_id", lejeaftale_id);
        return "redirect:/skadesrapporter/opret";
    }

    @GetMapping("/skadesrapporter/opret")
    public String showCreateForm(@RequestParam(required = false) int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale_id", lejeaftale_id);
        model.addAttribute("damageReport", new DamageReport());
        return "Form_DamageReport";
    }

    @PostMapping("/skadesrapporter/opret")
    public String processCreateForm(@ModelAttribute DamageReport damageReport, @RequestParam int lejeaftale_id) {
        System.out.println("Creating DamageReport for lejeaftale_id: " + lejeaftale_id);
        damageReport.setRentalAgreementId(lejeaftale_id);
        // damageReport.setRentalAgreementId(Integer.parseInt(lejeaftale_id));
        damageService.saveDamageReport(damageReport);
        return "redirect:/skadesrapporter/dashboard";
    }

    @GetMapping("/skadesrapporter/adddamage")
    public String showAddDamageForm(Model model) {
        model.addAttribute("damageReport", new DamageReport());
        return "AddDamage";
    }
}