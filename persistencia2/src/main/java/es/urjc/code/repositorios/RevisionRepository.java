package es.urjc.code.repositorios;


import es.urjc.code.modelo.Revision;
import es.urjc.code.modelo.RevisionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repositorio para revisiones.
 *
 *  @author J. Manuel Colmenar
 */
public interface RevisionRepository extends JpaRepository<Revision, Long> {

    @Query("select new es.urjc.code.modelo.RevisionDTO(r.avion.matricula, r.mecanicoEncargado.nombre, r.mecanicoEncargado.apellidos) " +
            "from Revision r order by r.avion.matricula")
    List<RevisionDTO> revisionesAvionMecanico();

}
