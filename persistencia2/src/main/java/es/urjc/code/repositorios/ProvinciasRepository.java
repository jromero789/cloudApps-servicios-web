package es.urjc.code.repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;

import es.urjc.code.modelo.Provincias;

public interface ProvinciasRepository extends MongoRepository<Provincias, String> {
    

}
