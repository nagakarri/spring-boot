package com.nkarri.waracle.cakemanager.controllers;

import com.nkarri.waracle.cakemanager.models.Cake;
import com.nkarri.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @GetMapping("/")
    public String getAllCakes(Model model){
        model.addAttribute("cakes", cakeService.getAllCakes());
        model.addAttribute("cake", new Cake());
        return "cakes";
    }

    @PostMapping("/")
    public String newCake(@ModelAttribute Cake cake, Model model) {
        Cake newCake = cakeService.newCake(cake);
        return "redirect:/";
    }

}
