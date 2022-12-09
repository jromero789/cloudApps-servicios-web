package com.cloudapps.practica3.server.eoloplant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EoloPlantService {
    
    @Autowired
    private EoloPlantRepository eolicPlantRepository;

    public List<EoloPlant> findAll() {
		return eolicPlantRepository.findAll();
	}

    public EoloPlant save(EoloPlant eoloPlant) {

        // TODO: Add logic here

		return eolicPlantRepository.save(eoloPlant);
	}

    public EoloPlant deleteById(long id) {

        EoloPlant eoloPlant = eolicPlantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Entity with id " + id + " does not exist"));
        eolicPlantRepository.delete(eoloPlant);
        return eoloPlant;
	}
}
