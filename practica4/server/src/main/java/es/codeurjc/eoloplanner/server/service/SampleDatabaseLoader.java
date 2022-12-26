package es.codeurjc.eoloplanner.server.service;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SampleDatabaseLoader {

	@Autowired 
	private EoloPlantRepository posts;
	
	@PostConstruct
	public void init() {
		posts.save(new EoloPlant("Madrid", "madrid-sunny-flat"));
	}
}
