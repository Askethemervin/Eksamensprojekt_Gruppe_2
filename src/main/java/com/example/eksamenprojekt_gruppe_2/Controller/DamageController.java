package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import com.example.eksamenprojekt_gruppe_2.Repository.DamageRepository;
import com.example.eksamenprojekt_gruppe_2.Repository.RentalAgreementRepository;
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
    private RentalAgreementRepository rentalAgreementRepository;

    @Autowired
    DamageService damageService;

    // Viser dashboardet for skadesrapporter
    @GetMapping("/skadesrapporter/dashboard")
    public String Showdashboard(Model model) {
        return "Dashboard_DamageReport";
    }

    // Viser en side, hvor man kan indtaste et lejeaftale ID
    @GetMapping ("/skadesrapporter/indtastid")
    public String showIndtastId () {
        return "ID_Site_Damagereport";
    }

    // Behandler indtastningen af lejeaftale ID og videresender til oprettelsessiden, hvis ID'et er gyldigt
    @PostMapping("/skadesrapporter/indtastid")
    public String processIdInput(@RequestParam("lejeaftale_id") int lejeaftale_id, Model model) {
        RentalAgreement rentalAgreement = rentalAgreementRepository.findById(lejeaftale_id);

        if (rentalAgreement != null) {
            model.addAttribute("lejeaftale_id", lejeaftale_id);

            DamageReport damageReport = new DamageReport();
            damageReport.setRentalAgreementId(lejeaftale_id);

            return "redirect:/skadesrapporter/opret/" + lejeaftale_id;
        } else {
            model.addAttribute("fejlbesked", "Indtast venligst et gyldigt lejeaftale id");
            return "ID_Site_Damagereport";
        }
    }

    // Opretter en skadesrapport for et specifikt lejeaftale ID
    @GetMapping ("/skadesrapporter/opret/{lejeaftale_id}")
    public String createDamageReportForId (@PathVariable ("lejeaftale_id") Integer lejeaftale_id, Model model) {

        List<DamageReport> damageReports = damageRepository.loadDamageReport(lejeaftale_id);

        double totalDamagePrice = damageReports.stream().mapToDouble(DamageReport::getPrice).sum();

        model.addAttribute("lejeaftale_id", lejeaftale_id);
        model.addAttribute("damageReports", damageReports);
        model.addAttribute("totalDamagePrice", totalDamagePrice);

        return "Form_DamageReport";
    }

    // Viser formularen til at tilføje en ny skade for et specifikt lejeaftale ID
    @GetMapping("/skadesrapporter/tilfojskader/{lejeaftale_id}")
    public String showCreateDamageForm(@PathVariable ("lejeaftale_id") int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale_id", lejeaftale_id);
        return "AddDamage";
    }

    // Behandler oprettelsen af en ny skadesrapport, og tilføjer skaden til skadesrapporten
    @PostMapping ("/skadesrapporter/tilfojskader")
    public String createDamageReport (
            @RequestParam ("lejeaftale_id") int lejeaftale_id,
            @RequestParam ("damageDescription") String damageDescription,
            @RequestParam ("price") String priceString,
            Model model) {

        try {
            double price = Double.parseDouble(priceString);
            DamageReport damageReport = new DamageReport();
            damageReport.setDamageDescription(damageDescription);
            damageReport.setPrice(price);
            damageReport.setRentalAgreementId(lejeaftale_id);

            damageService.saveDamageReport(damageReport);

            return "redirect:/skadesrapporter/opret/" + lejeaftale_id;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            model.addAttribute("error", "Indtast gyldigt input.");
            model.addAttribute("lejeaftale_id", lejeaftale_id);
            return "AddDamage";
        }
    }
}
