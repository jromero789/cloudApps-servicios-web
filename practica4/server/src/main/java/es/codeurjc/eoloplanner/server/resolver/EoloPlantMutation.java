package es.codeurjc.eoloplanner.server.resolver;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.model.EoloPlantInput;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EoloPlantMutation implements GraphQLMutationResolver {

	@Autowired
    private EoloPlantRepository eoloPlantRepository;


    public EoloPlant createEoloPlant(EoloPlantInput input) {
        EoloPlant eoloPlant = eoloPlantRepository.save(getEoloPlant(input));
        return eoloPlant;
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
