package es.codeurjc.eoloplanner.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;
import reactor.util.concurrent.Queues;

@Configuration
public class SubscriptionConfig {

  @Bean
  public Many<EoloPlant> eoloPlantSink() {
    return Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
  }

  @Bean
  public Flux<EoloPlant> eoloPlantFlux(Many<EoloPlant> eoloPlantSink) {
    return eoloPlantSink.asFlux();
  }

}
