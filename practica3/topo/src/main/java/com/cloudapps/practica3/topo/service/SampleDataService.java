package com.cloudapps.practica3.topo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.practica3.topo.model.Topo;

import jakarta.annotation.PostConstruct;

@Service
public class SampleDataService {

	@Autowired
	private TopoService topos; 
	
	@PostConstruct
	public void init() {

		topos.deleteAll();
		
		topos.save(new Topo("Madrid", "flat" ));
		topos.save(new Topo("Barcelona", "flat" ));
		topos.save(new Topo("Jaca", "mountain" ));
		topos.save(new Topo("Andorra", "mountain" ));
		topos.save(new Topo("Valencia", "flat" ));
		topos.save(new Topo("Sevilla", "flat" ));
		topos.save(new Topo("Zaragoza", "flat" ));
		topos.save(new Topo("Málaga", "flat" ));
		topos.save(new Topo("Murcia", "flat" ));
		topos.save(new Topo("Palma", "flat" ));
		topos.save(new Topo("Bilbao", "mountain" ));
		topos.save(new Topo("Alicante", "flat" ));
		topos.save(new Topo("Cordoba", "flat" ));
		topos.save(new Topo("Valladolid", "flat" ));
		topos.save(new Topo("Vigo", "flat" ));
		topos.save(new Topo("Gijon", "flat" ));
		topos.save(new Topo("Vitoria", "mountain" ));
	}
	
}
