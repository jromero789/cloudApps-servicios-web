package es.urjc.code.repositorios;

import es.urjc.code.modelo.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para aeropuertos.
 *
 *  @author J. Manuel Colmenar
 */
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

}
