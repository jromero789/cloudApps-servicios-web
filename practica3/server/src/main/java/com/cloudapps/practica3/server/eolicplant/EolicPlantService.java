package com.cloudapps.practica3.server.eolicplant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EolicPlantService {
    
    @Autowired
    private EolicPlantRepository eolicPlantRepository;


    public EolicPlant save(EolicPlant eolicPlant) {

        // TODO: Add logic here

		return eolicPlantRepository.save(eolicPlant);
	}
}
