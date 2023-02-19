package es.urjc.code.repositorios;

import es.urjc.code.modelo.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para vuelos.
 *
 *  @author J. Manuel Colmenar
 */
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    // Between incluye extremos.
    @Query("select v from Vuelo v where v.origen.ciudad = ?1 and " +
            "v.fechaSalida >= STR_TO_DATE(?2, '%d/%m/%Y') " +
            "and v.fechaSalida < STR_TO_DATE(?2, '%d/%m/%Y')+1 " +
            "ORDER BY v.fechaSalida")
    List<Vuelo> vuelosCiudadFecha(String ciudad, String fecha);
}
