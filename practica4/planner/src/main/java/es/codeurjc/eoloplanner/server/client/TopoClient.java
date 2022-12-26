package es.codeurjc.eoloplanner.server.client;

import es.codeurjc.eoloplanner.server.model.LandscapeResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class TopoClient {

    private static final String TOPO_HOST = "localhost";
    private static final int TOPO_PORT = 8181;

    @Async
    public CompletableFuture<String> getLandscape(String city) {
        
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://"+TOPO_HOST+":"+TOPO_PORT+"/api/topographicdetails/" + city;
        
        LandscapeResponse response = restTemplate.getForObject(url, LandscapeResponse.class);
        
        return CompletableFuture.completedFuture(response.getLandscape());
    }
}
