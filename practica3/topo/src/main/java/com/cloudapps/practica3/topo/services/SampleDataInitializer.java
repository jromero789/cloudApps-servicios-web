package com.cloudapps.practica3.topo.services;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.cloudapps.practica3.topo.model.Topo;
import com.cloudapps.practica3.topo.repository.TopoRepository;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;

@Component
public class SampleDataInitializer {

    private final TopoRepository topos;

    SampleDataInitializer(TopoRepository topos){
        this.topos = topos;
    }

    @PostConstruct
    public void initDatabase() {

		topos.deleteAll();
		
        Flux<Topo> topos = Flux.just(	
			new Topo("Madrid", "flat" ),
			new Topo("Barcelona", "flat" ),
			new Topo("Jaca", "mountain" ),
			new Topo("Andorra", "mountain" ),
			new Topo("Valencia", "flat" ),
			new Topo("Sevilla", "flat" ),
			new Topo("Zaragoza", "flat" ),
			new Topo("Málaga", "flat" ),
			new Topo("Murcia", "flat" ),
			new Topo("Palma", "flat" ),
			new Topo("Bilbao", "mountain" ),
			new Topo("Alicante", "flat" ),
			new Topo("Cordoba", "flat" ),
			new Topo("Valladolid", "flat" ),
			new Topo("Vigo", "flat" ),
			new Topo("Gijon", "flat" ),
			new Topo("Vitoria", "mountain" )
			);
        topos
            .flatMap(this.topos::save)
            .blockLast();
    }
}