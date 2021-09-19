package com.nkarri.waracle.cakemanager.service;

import com.nkarri.waracle.cakemanager.data.CakeRepository;
import com.nkarri.waracle.cakemanager.models.Cake;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CakeService {

    private final CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> getAllCakes(){
        return cakeRepository.findAll();
    }

    public Cake newCake(Cake cake){
        return cakeRepository.save(cake);
    }

    public Optional<Cake> getCake(Long id){
        return cakeRepository.findById(id);
    }
}
