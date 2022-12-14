package com.cloudapps.practica3.topo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.practica3.topo.model.Topo;
import com.cloudapps.practica3.topo.repository.TopoRepository;

import reactor.core.publisher.Flux;

@Service
public class TopoService {
	
	@Autowired
	private TopoRepository topos;

	public void save(Topo topo) {
		topos.save(topo);		
	}

	public Flux<Topo> findAll() {
		return topos.findAll();
	}

	public Flux<Topo> findByCity(Optional<String> city) {
		return city
            .map(c -> topos.findByCity(c))
            .orElseGet(null);
	}

	public void deleteAll() {
		topos.deleteAll();
	}
	
}