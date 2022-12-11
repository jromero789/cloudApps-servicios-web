package com.cloudapps.practica3.server.eoloplant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cloudapps.practica3.server.topo.TopoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EoloPlantService {
    
    @Autowired
    private EoloPlantRepository eolicPlantRepository;

    public List<EoloPlant> findAll() {
		return eolicPlantRepository.findAll();
	}

    public EoloPlant save(EoloPlant eoloPlant) throws JsonProcessingException {

        String city = eoloPlant.getCity();
        String weather = "ToDo";
        String landscape = getTopo(city);
        eoloPlant.setPlanning(city + "-" + weather + "-" + landscape);

		return eolicPlantRepository.save(eoloPlant);
	}

    public EoloPlant deleteById(long id) {

        EoloPlant eoloPlant = eolicPlantRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Entity with id " + id + " does not exist"));
        eolicPlantRepository.delete(eoloPlant);
        return eoloPlant;
	}

    @Async
    private String getTopo(String city) throws JsonProcessingException{
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8081/api/topographicdetails/" + city, String.class);
		
        ObjectMapper objectMapper = new ObjectMapper();
        TopoDto topoDto = objectMapper.readValue(response, TopoDto.class);
        return topoDto.getLandscape();
    }
}
