package com.nkarri.waracle.cakemanager.service;

import com.nkarri.waracle.cakemanager.models.Cake;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CakeService {

    private static final List<Cake> cakes = new ArrayList<>();

    static{
        for(int i=0; i<10; i++){
            cakes.add(new Cake(i,"Room"+i, "R"+i, "Q"));
        }
    }

    public List<Cake> getAllCakes(){
        return cakes;
    }
}
