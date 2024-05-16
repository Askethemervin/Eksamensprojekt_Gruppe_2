package com.example.eksamenprojekt_gruppe_2.Controller;

import com.example.eksamenprojekt_gruppe_2.Model.Damages;
import org.springframework.ui.Model;
import com.example.eksamenprojekt_gruppe_2.Service.DamagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DamageController {

    @Autowired
    private DamagesService damagesService;

    @GetMapping("/skadesrapporter/dashboard")
    public String Showdashboard(Model model) {
        List<Damages> damagesList = damagesService.getAllDamages();
        model.addAttribute("damagesList", damagesList);
        return "Dashboard_DamageReport";
    }

    @GetMapping("/skadesrapporter/indtastid")
    public String ShowInputId(Model model) {
        return "ID_Site_DamageReport";
    }

    @PostMapping("/skadesrapporter/indtastid")
    public String processIdInput(@RequestParam int lejeaftale_id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("lejeaftale_id", lejeaftale_id);
        return "redirect:/skadesrapporter/opret";
    }

    @GetMapping("/skadesrapporter/opret")
    public String showCreateForm(@RequestParam(required = false) int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale_id", lejeaftale_id);
        model.addAttribute("damage", new Damages());
        return "Form_DamageReport";
    }

    @PostMapping("/skadesrapporter/opret")
    public String processCreateForm(@ModelAttribute Damages damage, @RequestParam int lejeaftale_id) {
       damage.setDamageReportId(lejeaftale_id);
        damagesService.saveDamage(damage);
        return "redirect:/skadesrapporter/dashboard";
    }

    @GetMapping("/skadesrapporter/adddamage")
    public String showAddDamageForm(Model model) {
        model.addAttribute("damage", new Damages());
        return "AddDamage";
    }
}
