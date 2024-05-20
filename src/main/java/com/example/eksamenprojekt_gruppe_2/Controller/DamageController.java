package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Repository.DamageRepository;
import com.example.eksamenprojekt_gruppe_2.Service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DamageController {

    @Autowired
    private DamageRepository damageRepository;

    @Autowired
    DamageService damageService;

    @GetMapping("/skadesrapporter/dashboard")
    public String Showdashboard(Model model) {
        return "Dashboard_DamageReport";
    }

    @GetMapping ("/skadesrapporter/indtastid")
    public String showIndtastId () {
        return "ID_Site_Damagereport";
    }

    @PostMapping ("/skadesrapporter/indtastid")
    public String processIdInput (@RequestParam("lejeaftale_id") int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale_id", lejeaftale_id);

        DamageReport damageReport = new DamageReport();
        damageReport.setRentalAgreementId(lejeaftale_id);

        return "redirect:/skadesrapporter/opret/" + lejeaftale_id;
    }

    @GetMapping ("/skadesrapporter/opret/{lejeaftale_id}")
    public String createDamageReportForId (@PathVariable ("lejeaftale_id") Integer lejeaftale_id, Model model) {
        if (lejeaftale_id == null) {
            return "redirect:/skadesrapporter/dashboard";
        }
        List<DamageReport> damageReports = damageRepository.loadDamageReport(lejeaftale_id);
        model.addAttribute("lejeaftale_id", lejeaftale_id);
        model.addAttribute("damageReports", damageReports);

        return "Form_DamageReport";
    }

    @GetMapping("/skadesrapporter/adddamage/{lejeaftale_id}")
    public String showCreateDamageForm(@PathVariable ("lejeaftale_id") int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale_id", lejeaftale_id);
        return "AddDamage";
    }

    @PostMapping ("/skadesrapporter/adddamage")
    public ModelAndView createDamageReport (
            @RequestParam ("lejeaftale_id") int lejeaftale_id,
            @RequestParam ("damageDescription") String damageDescription,
            @RequestParam ("price") double price) {

        DamageReport damageReport = new DamageReport();
        damageReport.setDamageDescription(damageDescription);
        damageReport.setPrice(price);
        damageReport.setRentalAgreementId(lejeaftale_id);

        damageService.saveDamageReport(damageReport);

        return new ModelAndView("redirect:/skadesrapporter/opret/" + lejeaftale_id);
    }
}
