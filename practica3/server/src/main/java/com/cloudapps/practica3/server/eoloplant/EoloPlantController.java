package com.cloudapps.practica3.server.eoloplant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EoloPlantController {

    @Autowired
    private EoloPlantService eolicPlantService;
    
    @QueryMapping
    public List<EoloPlant> getEoloPlants() {
		return eolicPlantService.findAll();
	}

    @QueryMapping
    public EoloPlant getEoloPlant(@Argument Long id) {
        return eolicPlantService.findById(id);
    }

    @MutationMapping
    public EoloPlant createEoloPlant(@Argument String city) {
        EoloPlant eoloPlant = new EoloPlant();
        eoloPlant.setCity(city);
        eolicPlantService.save(eoloPlant);

        return eoloPlant;
    }
}
