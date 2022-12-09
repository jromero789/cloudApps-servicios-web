package com.cloudapps.practica3.server.eolicplant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EolicPlantController {

    @Autowired
    private EolicPlantService eolicPlantService;
    
    @QueryMapping
    public List<EolicPlant> getEolicPlants() {
		return eolicPlantService.findAll();
	}

    @QueryMapping
    public EolicPlant getEolicPlant(@Argument Long id) {
        return eolicPlantService.findById(id);
    }

    @MutationMapping
    public EolicPlant createEolicPlant(@Argument String name) {
        EolicPlant eolicPlant = new EolicPlant();
        eolicPlant.setName(name);
        eolicPlantService.save(eolicPlant);

        return eolicPlant;
    }
}
