package es.codeurjc.eoloplanner.server.resolver;

import es.codeurjc.eoloplanner.server.service.EoloPlantService;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import reactor.core.publisher.Flux;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Flow.Publisher;


@Component
public class EoloPlantQuery implements GraphQLQueryResolver {

	@Autowired
	private EoloPlantService eoloPlants;


	public EoloPlant eoloPlant(Long id) {
        Optional<EoloPlant> eoloPlant = eoloPlants.findById(id);
        if(eoloPlant.isPresent())
            return eoloPlant.get();
        throw new GraphQLException("EoloPlant does not exist");
    }

	public List<EoloPlant> eoloPlants() {
		Collection collection = eoloPlants.findAll();
		List<EoloPlant> list = (List<EoloPlant>) collection;
		return list;
	}
}
