package org.cloudapps;

import org.cloudapps.grpc.*;

import io.quarkus.grpc.GrpcService;
import java.lang.Thread;
import java.util.Random;

import io.smallrye.mutiny.Uni;

@GrpcService
public class WeatherGrpcService implements WeatherService {

    @Override
    public Uni<WeatherResponse> weather(WeatherRequest request) {

        randomTimeout();
        System.out.println("Request received from client:\n" + request);

        String weatherType = startWithVowel(request.getCity()) ? "Rainny" :"Sunny";

        WeatherResponse response = WeatherResponse.newBuilder()
                .setWeatherType(weatherType)
                .build();
        return Uni.createFrom().item(response);
    }

    boolean startWithVowel(String word) {
        return "eaiouEAIOU".indexOf(word.charAt(0)) >=0;
    }

    void randomTimeout(){
        Random r = new Random();
        int low = 1000;
        int high = 3000;
        int result = r.nextInt(high-low) + low;
        try {
            Thread.sleep(result);
        } catch(InterruptedException e) {
            System.out.println("got interrupted!");
        }
    }
}