package com.cloudapps.practica3.topo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.practica3.topo.model.Topo;
import com.cloudapps.practica3.topo.repository.TopoRepository;

@Service
public class TopoService {
	
	@Autowired
	private TopoRepository topos;

	public void save(Topo topo) {
		topos.save(topo);		
	}

	public List<Topo> findAll() {
		return topos.findAll();
	}

	public Optional<Topo> findByCity(String city) {
		return topos.findByCity(city);
	}

	public void deleteAll() {
		topos.deleteAll();
	}
	
}