package com.cloudapps.practica3.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudapps.practica3.server.eolicplant.EolicPlant;
import com.cloudapps.practica3.server.eolicplant.EolicPlantRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {
    
    @Autowired
    private EolicPlantRepository eolicPlantRepository;

    @PostConstruct
	public void init() {

		EolicPlant eolicPlant1 = new EolicPlant("Madrid");
		eolicPlantRepository.save(eolicPlant1);

		EolicPlant eolicPlant2 = new EolicPlant("Buenos Aires");
		eolicPlantRepository.save(eolicPlant2);
    }
}
