package com.cloudapps.practica3.server.eolicplant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EolicPlantService {
    
    @Autowired
    private EolicPlantRepository eolicPlantRepository;

    public List<EolicPlant> findAll() {
		return eolicPlantRepository.findAll();
	}

    public EolicPlant findById(long id) {
		return eolicPlantRepository.findById(id).orElseThrow();
	}

    public EolicPlant save(EolicPlant eolicPlant) {

        // TODO: Add logic here

		return eolicPlantRepository.save(eolicPlant);
	}
}
