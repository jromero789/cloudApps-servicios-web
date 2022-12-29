package es.codeurjc.eoloplanner.server.resolver;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class EoloPlantSubscription implements GraphQLSubscriptionResolver {

	@Autowired
    private EoloPlantRepository eoloPlantRepository;

    public Publisher<List<EoloPlant>> eoloPlants() {
        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            List<EoloPlant> people = (List<EoloPlant>) eoloPlantRepository.findAll();
            subscriber.onNext(people);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public Publisher<EoloPlant> eoloPlant(Long id) {
        return subscriber -> Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            Optional<EoloPlant> eoloPlant = eoloPlantRepository.findById(id);
            if(eoloPlant.isPresent())
                subscriber.onNext(eoloPlant.get());
        }, 0, 1, TimeUnit.SECONDS);
    }
}
