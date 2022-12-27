package es.codeurjc.eoloplanner.server.service;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
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

    public EoloPlant createEoloplant(EoloPlant eoloPlant) {

        eoloPlantRepository.save(eoloPlant);

        streamBridge.send("create", eoloPlant);
        
        return eoloPlant;
    }

    public EoloPlant update(EoloPlant eoloPlant) {
        
        return eoloPlantRepository.save(eoloPlant);
    }

    public EoloPlant deleteById(long id) {

        EoloPlant eoloPlant = eoloPlantRepository.findById(id).orElseThrow();

        eoloPlantRepository.deleteById(id);

        return eoloPlant;
    }
}
