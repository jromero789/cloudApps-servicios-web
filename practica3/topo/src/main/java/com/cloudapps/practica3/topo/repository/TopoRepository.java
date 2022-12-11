package com.cloudapps.practica3.topo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloudapps.practica3.topo.model.Topo;

public interface TopoRepository extends MongoRepository<Topo, String> {

    Optional<Topo> findByCity(String city);
}

