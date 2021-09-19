package com.nkarri.waracle.cakemanager.controllers;

import com.nkarri.waracle.cakemanager.models.Cake;
import com.nkarri.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cakes")
public class CakeRestController {

    @Autowired
    private CakeService cakeService;

    public CakeRestController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping
    public List<Cake> getAllCakes(Model model){
        return cakeService.getAllCakes();
    }


}
