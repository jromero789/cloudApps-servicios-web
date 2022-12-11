package com.cloudapps.practica3.topo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudapps.practica3.topo.model.ResponseDto;
import com.cloudapps.practica3.topo.model.Topo;
import com.cloudapps.practica3.topo.service.TopoService;

@RestController
@RequestMapping("/api/topographicdetails")
public class TopoController {

	@Autowired
	private TopoService topos;

	@GetMapping("/{city}")
	public ResponseDto getTopo(@PathVariable String city) {

		return topos.findByCity(city).map(this::toResponseDTO).orElseThrow();
	}

    private ResponseDto toResponseDTO(Topo topo) {
        return new ResponseDto(topo.getId(), topo.getLandscape());
    }
}
