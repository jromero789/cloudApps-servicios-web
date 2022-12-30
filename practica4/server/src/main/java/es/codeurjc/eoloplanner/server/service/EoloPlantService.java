package es.codeurjc.eoloplanner.server.service;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.repository.EoloPlantRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks.Many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EoloPlantService {

    @Autowired
    private Flux<EoloPlant> eoloPlantEvents;
    @Autowired
  	private Many<EoloPlant> eoloPlantSink;
    @Autowired
    private StreamBridge streamBridge;
    @Autowired
    private EoloPlantRepository eoloPlantRepository;


    public List<EoloPlant> findAll() {
        return eoloPlantRepository.findAll();
    }

    public Optional<EoloPlant> findById(long id) {
        return eoloPlantRepository.findById(id);
    }

    public EoloPlant create(EoloPlant eoloPlant) {

        eoloPlantRepository.save(eoloPlant);

        eoloPlantSink.tryEmitNext(eoloPlant);
        streamBridge.send("create", eoloPlant);

        return eoloPlant;
       
    }

    public EoloPlant update(EoloPlant eoloPlant) {

        eoloPlantRepository.save(eoloPlant);

        eoloPlantSink.tryEmitNext(eoloPlant);

        return eoloPlant;
    }

    public EoloPlant deleteById(long id) {

        EoloPlant eoloPlant = eoloPlantRepository.findById(id).orElseThrow();

        eoloPlantRepository.deleteById(id);

        eoloPlantSink.tryEmitNext(eoloPlant);

        return eoloPlant;
    }

    public Flux<EoloPlant> subscriptionEoloPlant(Long id) {
        return eoloPlantEvents
            .filter(e -> Objects.equals(e.getId(), id));
    }
}
