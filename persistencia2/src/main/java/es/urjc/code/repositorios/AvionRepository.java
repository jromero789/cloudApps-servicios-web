package es.urjc.code.repositorios;

import es.urjc.code.modelo.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para aviones.
 *
 *  @author J. Manuel Colmenar
 */
public interface AvionRepository extends JpaRepository<Avion, Long> {
}

