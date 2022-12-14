package com.cloudapps.practica3.topo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.cloudapps.practica3.topo.repository")
public class TopoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopoApplication.class, args);
	}

}
