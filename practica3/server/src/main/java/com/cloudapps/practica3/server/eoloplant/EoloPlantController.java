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
    public List<EoloPlant> eoloPlants() {
		return eolicPlantService.findAll();
	}

    @QueryMapping
    public EoloPlant eoloPlant(@Argument Long id) {
        return eolicPlantService.findById(id);
    }

    @MutationMapping
    public EoloPlant createEoloPlant(@Argument EoloPlantInput eoloPlant) {
        String city = eoloPlant.getCity();
        EoloPlant ep = new EoloPlant(city);
        return eolicPlantService.save(ep);
    }
}
