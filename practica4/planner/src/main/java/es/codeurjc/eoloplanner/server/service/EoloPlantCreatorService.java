package es.codeurjc.eoloplanner.server.service;

import es.codeurjc.eoloplanner.server.client.TopoClient;
import es.codeurjc.eoloplanner.server.client.WeatherClient;
import es.codeurjc.eoloplanner.server.model.EoloPlant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class EoloPlantCreatorService {

    @Autowired
    private WeatherClient weatherClient;

    @Autowired
    private TopoClient topoClient;

    @Autowired
    private StreamBridge streamBridge;
    

    public void createEoloPlant(EoloPlant eoloPlant) throws ExecutionException, InterruptedException {

        String city = eoloPlant.getCity();

        StringBuffer planningCreation = new StringBuffer(city);

        CompletableFuture<Void> landscape = topoClient.getLandscape(city).thenAccept(l -> {
            System.out.println("L");
            planningCreation.append("-");
            planningCreation.append(l);
        });

        CompletableFuture<Void> weather = weatherClient.getWeather(city).thenAccept(w -> {
            System.out.println("W");
            planningCreation.append("-");
            planningCreation.append(w);
        });;

        CompletableFuture.allOf(weather, landscape).get();

        String planning = planningCreation.toString();

        planning = planning.matches("^[A-Ma-m].*") ?
                planning.toLowerCase() :
                planning.toUpperCase();

        simulateProcessWaiting();

        eoloPlant.setPlanning(planning);
        streamBridge.send("progress", eoloPlant);
    }

    private void simulateProcessWaiting() {
        try {
            Thread.sleep(1000 + new Random().nextInt(2000));
        } catch (InterruptedException e) {}
    }
}
