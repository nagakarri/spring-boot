package com.nkarri.waracle.cakemanager.controllers;

import com.nkarri.waracle.cakemanager.error.CakeNotFoundException;
import com.nkarri.waracle.cakemanager.models.Cake;
import com.nkarri.waracle.cakemanager.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class CakeRestController {

    @Autowired
    private CakeService cakeService;

    public CakeRestController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/cakes")
    public List<Cake> getAllCakes(){
        return cakeService.getAllCakes();
    }

    @PostMapping("/cakes")
    Cake newCake(@Valid @RequestBody Cake cake) {
        return cakeService.newCake(cake);
    }

    @GetMapping("/cakes/{id}")
    Cake getCake(@PathVariable Long id) {
        return cakeService.getCake(id)
                .orElseThrow(() -> new CakeNotFoundException(id));
    }

}
