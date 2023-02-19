package es.urjc.code.repositorios;

import es.urjc.code.modelo.CiudadFechaDTO;
import es.urjc.code.modelo.Tripulante;
import es.urjc.code.modelo.TripulanteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripulanteRepository extends JpaRepository<Tripulante, Long> {

    Tripulante findByCodigo(String codigo);

    @Query("select new es.urjc.code.modelo.CiudadFechaDTO(v.origen.ciudad, v.fechaSalida) " +
            "from Vuelo v, TripulanteVuelo tv where v.id = tv.vuelo.id and tv.tripulante.id=?1")
    List<CiudadFechaDTO> despeguesFecha(long id);

    // Ordenado por número de vuelos.
    @Query("select new es.urjc.code.modelo.TripulanteDTO(t.nombre, t.apellidos, count(v), sum(v.duracion)) " +
            "from Vuelo v, TripulanteVuelo tv, Tripulante t " +
            "where v.id = tv.vuelo.id and tv.tripulante.id = t.id "
            + "group by t.nombre, t.apellidos "
            + "order by 3")
    List<TripulanteDTO> vuelosHorasPorTripulante();
}
