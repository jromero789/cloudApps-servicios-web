package com.cloudapps.practica3.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudapps.practica3.server.eoloplant.EoloPlant;
import com.cloudapps.practica3.server.eoloplant.EoloPlantRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {
    
    @Autowired
    private EoloPlantRepository eolicPlantRepository;

    @PostConstruct
	public void init() {

		EoloPlant eoloPlant1 = new EoloPlant("Madrid");
		eolicPlantRepository.save(eoloPlant1);

		EoloPlant eoloPlant2 = new EoloPlant("Buenos Aires");
		eolicPlantRepository.save(eoloPlant2);
    }
}
