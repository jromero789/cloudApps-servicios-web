package es.codeurjc.eoloplanner.server.resolver;

import graphql.GraphQLException;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks.Many;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;


@Controller
public class EoloPlantController {
    
    @Autowired
    private Flux<EoloPlant> eoloPlantEvents;

    @Autowired
  	private Many<EoloPlant> eoloPlantSink;

    @Autowired
    private EoloPlantRepository eoloPlantRepository;

    @Autowired
    private EoloPlantService eoloPlants;

    @QueryMapping
    public EoloPlant eoloPlant(@Argument Long id) {
        Optional<EoloPlant> eoloPlant = eoloPlants.findById(id);
        if(eoloPlant.isPresent())
            return eoloPlant.get();
        throw new GraphQLException("EoloPlant does not exist");
    }

    @QueryMapping
	public List<EoloPlant> eoloPlants() {
		Collection collection = eoloPlants.findAll();
		List<EoloPlant> list = (List<EoloPlant>) collection;
		return list;
	}

    @MutationMapping
	public EoloPlant createEoloPlant(@Argument EoloPlantInput eoloPlantInput) {
		
        EoloPlant eoloPlant = eoloPlantRepository.save(getEoloPlant(eoloPlantInput));

        eoloPlantSink.tryEmitNext(eoloPlant);
        return eoloPlant;
        // return eoloPlants.createEoloplant(getEoloPlant(input));
    }


    @MutationMapping
	public EoloPlant updateEoloPlant(EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = getEoloPlant(eoloPlantInput);
        Optional<EoloPlant> targetEoloPlant = eoloPlantRepository.findById(eoloPlant.getId());
        if(targetEoloPlant.isPresent()) {
            return eoloPlantRepository.save(eoloPlant);
        }
        throw new GraphQLException("EoloPlant id " + eoloPlant.getId() + " does not exist.");
    }


    @SubscriptionMapping
    public Publisher<List<EoloPlant>> subscriptionEoloPlants() {
        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            List<EoloPlant> people = (List<EoloPlant>) eoloPlantRepository.findAll();
            subscriber.onNext(people);
        }, 0, 1, TimeUnit.SECONDS);
    }

    @SubscriptionMapping
    public Publisher<EoloPlant> subscriptionEoloPlant(@Argument Long id) {
        return eoloPlantEvents
            .filter(e -> e.getId() == id);
        //return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
        //    Optional<EoloPlant> eoloPlant = eoloPlantRepository.findById(id);
        //    if(eoloPlant.isPresent())
        //        subscriber.onNext(eoloPlant.get());
        //}, 0, 1, TimeUnit.SECONDS);
    }



    private EoloPlant getEoloPlant(EoloPlantInput eoloPlantInput) {
        EoloPlant eoloPlant = new EoloPlant();
        eoloPlant.setCity(eoloPlantInput.getCity());
        eoloPlant.setPlanning(eoloPlantInput.getPlanning());

        return eoloPlant;
    }

}
