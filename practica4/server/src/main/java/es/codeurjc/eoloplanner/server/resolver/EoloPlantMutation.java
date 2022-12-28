package es.codeurjc.eoloplanner.server.resolver;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.model.EoloPlantInput;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;
import es.codeurjc.eoloplanner.server.service.EoloPlantService;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;


@Component
public class EoloPlantMutation implements GraphQLMutationResolver {

	@Autowired
    private EoloPlantRepository eoloPlantRepository;

	@Autowired
    private EoloPlantService eoloPlants;


	public EoloPlant createEoloPlant(@Argument EoloPlantInput input) {
		
        //EoloPlant eoloPlant = eoloPlantRepository.save(getEoloPlant(input));
        return eoloPlants.createEoloplant(getEoloPlant(input));
    }

    private EoloPlant getEoloPlant(EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = new EoloPlant();
        eoloPlant.setCity(eoloPlantInput.getCity());
        eoloPlant.setPlanning(eoloPlantInput.getPlanning());

        return eoloPlant;
    }

	public EoloPlant updateEoloPlant(EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = getEoloPlant(eoloPlantInput);
        Optional<EoloPlant> targetEoloPlant = eoloPlantRepository.findById(eoloPlant.getId());
        if(targetEoloPlant.isPresent()) {
            return eoloPlantRepository.save(eoloPlant);
        }
        throw new GraphQLException("EoloPlant id " + eoloPlant.getId() + " does not exist.");
    }
   
}
