package com.cloudapps.practica3.topo.controller;

import java.time.Duration;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.practica3.topo.model.ResponseDto;
import com.cloudapps.practica3.topo.model.Topo;
import com.cloudapps.practica3.topo.services.TopoService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/topographicdetails")
public class TopoController {

	@Autowired
	private TopoService topos;

	@GetMapping("/{city}")
	public Flux<ResponseDto> getTopo(@PathVariable (required = true) Optional<String> city) {
		Duration random = randomNumber();
		return topos.findByCity(city).map(this::toResponseDTO).timeout(random);
	}

    private ResponseDto toResponseDTO(Topo topo) {
        return new ResponseDto(topo.getCity(), topo.getLandscape());
    }

	private Duration randomNumber(){
		Random r = new Random();
        int low = 1000;
        int high = 3000;
        long result = r.nextInt(high-low) + low;
		Duration durationInMs = Duration.ofMillis(result);
		return durationInMs;

	}
}
