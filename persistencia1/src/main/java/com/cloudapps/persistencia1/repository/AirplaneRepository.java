package com.cloudapps.persistencia1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cloudapps.persistencia1.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    
}