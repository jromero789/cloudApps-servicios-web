package com.cloudapps.practica3.server.eolicplant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EolicPlantController {

    @Autowired
    private EolicPlantService eolicPlantService;
    
    @MutationMapping
    public EolicPlant createPost(@Argument String name) {
        EolicPlant eolicPlant = new EolicPlant();
        eolicPlant.setName(name);
        eolicPlantService.save(eolicPlant);

        return eolicPlant;
    }
}
