package com.cloudapps.practica3.topo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cloudapps.practica3.topo.model.Topo;

import reactor.core.publisher.Flux;

public interface TopoRepository extends ReactiveMongoRepository<Topo, String> {

    Flux<Topo> findByCity(String city);
}

