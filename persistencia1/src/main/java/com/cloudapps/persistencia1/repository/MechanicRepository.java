package com.cloudapps.persistencia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
    
}
