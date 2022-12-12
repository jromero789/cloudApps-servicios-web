package com.cloudapps.practica3.server.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import net.devh.boot.grpc.client.inject.GrpcClient;


import io.quarkus.runtime.QuarkusApplication;

@Controller
public class WeatherServiceGrpcClient implements QuarkusApplication {

	@GrpcClient("weatherServer")
	private WeatherServiceBlockingStub client;
	
	@Override
	public void run(String... args) throws Exception {
		
        WeatherRequest request = WeatherRequest.newBuilder().setCity("Madrid").build();	        
        WeatherResponse response = client.hello(request);

	    System.out.println("Response received from server:\n" + response);

		
	}	
}
