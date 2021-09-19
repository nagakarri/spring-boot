package com.nkarri.waracle.cakemanager.data;

import com.nkarri.waracle.cakemanager.models.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Long> {
}
