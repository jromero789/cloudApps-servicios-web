package es.codeurjc.eoloplanner.server.resolver;

import graphql.GraphQLException;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.model.EoloPlantInput;
import es.codeurjc.eoloplanner.server.service.EoloPlantService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;


@Controller
public class EoloPlantController {

    @Autowired
    private EoloPlantService eoloPlantService;


    @QueryMapping
    public EoloPlant eoloPlant(@Argument Long id) {
        Optional<EoloPlant> eoloPlant = eoloPlantService.findById(id);
        if(eoloPlant.isPresent())
            return eoloPlant.get();
        throw new GraphQLException("EoloPlant does not exist");
    }

    @QueryMapping
	public List<EoloPlant> eoloPlants() {
		return eoloPlantService.findAll();
	}

    @MutationMapping
	public EoloPlant createEoloPlant(@Argument EoloPlantInput eoloPlantInput) {
        return eoloPlantService.create(getEoloPlant(eoloPlantInput));
    }

    @MutationMapping
	public EoloPlant updateEoloPlant(@Argument EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = getEoloPlant(eoloPlantInput);
        Optional<EoloPlant> targetEoloPlant = eoloPlantService.findById(eoloPlant.getId());
        if(targetEoloPlant.isPresent()) {
            return eoloPlantService.update(eoloPlant);
        }
        throw new GraphQLException("EoloPlant id " + eoloPlant.getId() + " does not exist.");
    }

    @MutationMapping
	public EoloPlant deleteEoloPlant(@Argument Long id) {
		return eoloPlantService.deleteById(id);
	}

    @SubscriptionMapping
    public Publisher<List<EoloPlant>> subscriptionEoloPlants() {
        // TODO: Remove poller. Useful for debug purposes
        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            List<EoloPlant> people = eoloPlantService.findAll();
            subscriber.onNext(people);
        }, 0, 1, TimeUnit.SECONDS);
    }

    @SubscriptionMapping
    public Publisher<EoloPlant> subscriptionEoloPlant(@Argument Long id) {
        return eoloPlantService.subscriptionEoloPlant(id);
    }


    private EoloPlant getEoloPlant(EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = new EoloPlant();
        eoloPlant.setId(eoloPlantInput.getId());
        eoloPlant.setCity(eoloPlantInput.getCity());
        eoloPlant.setPlanning(eoloPlantInput.getPlanning());

        return eoloPlant;
    }

}
