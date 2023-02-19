
package es.urjc.code.repositorios;

import es.urjc.code.modelo.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para mecánicos.
 *
 *  @author J. Manuel Colmenar
 */
public interface MecanicoRepository extends JpaRepository<Mecanico, Long> {
}
