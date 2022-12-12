package org.cloudapps;

import org.cloudapps.grpc.*;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class WeatherGrpcService implements WeatherService {

    @Override
    public Uni<WeatherResponse> weather(WeatherRequest request) {

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
}