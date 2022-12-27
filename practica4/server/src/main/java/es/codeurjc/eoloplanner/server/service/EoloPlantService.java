package es.codeurjc.eoloplanner.server.service;

import es.codeurjc.eoloplanner.server.Client;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class EoloPlantService {

    @Autowired
    private EoloPlantRepository eoloPlantRepository;

    @Autowired
    private StreamBridge streamBridge;


    public Collection<EoloPlant> findAll() {
        return eoloPlantRepository.findAll();
    }

    public Optional<EoloPlant> findById(long id) {
        return eoloPlantRepository.findById(id);
    }

    public EoloPlant createEoloplant(EoloPlant eoloPlantCreationRequest) throws ExecutionException, InterruptedException {

        String city = eoloPlantCreationRequest.getCity();
        EoloPlant eoloPlant = new EoloPlant(city);
        eoloPlantRepository.save(eoloPlant);

        Client client = new Client("Create2", UUID.randomUUID().toString());
        streamBridge.send("create", client);
        
        return eoloPlant;
    }

    public EoloPlant deleteById(long id) {

        EoloPlant eoloPlant = eoloPlantRepository.findById(id).orElseThrow();

        eoloPlantRepository.deleteById(id);

        return eoloPlant;
    }
}
