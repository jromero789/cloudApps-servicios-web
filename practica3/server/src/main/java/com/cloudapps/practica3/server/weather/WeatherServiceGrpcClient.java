package com.cloudapps.practica3.server.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Service
public class WeatherServiceGrpcClient {

	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

	// @Override
	// public void run(String... args) throws Exception {
		
    //     // WeatherRequest request = WeatherRequest.newBuilder().setCity("Madrid").build();	        
    //     // WeatherResponse response = client.hello(request);

	//     // System.out.println("Response received from server:\n" + response);

	// }	
}
