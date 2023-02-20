package es.urjc.code;

import es.urjc.code.modelo.*;
import es.urjc.code.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Cargador de la BD y solución de apartados de la práctica.
 *
 * @author J. Manuel Colmenar
 */
@Controller
public class DatabaseLoader implements CommandLineRunner {

        @Autowired
        private AvionRepository avionRepository;

        @Autowired
        private AeropuertoRepository aeropuertoRepository;

        @Autowired
        private TripulanteRepository tripulanteRepository;

        @Autowired
        private VueloRepository vueloRepository;

        @Autowired
        private MecanicoRepository mecanicoRepository;

        @Autowired
        private RevisionRepository revisionRepository;

        @Autowired
        private ProvinciasRepository provinciasRepository;

        @Override
        public void run(String... args) throws Exception {

                // -- Mostrar info

                // Apartado 2: consultas
                // Para cada avión, mostrar el nombre y apellidos de los mecánicos responsables
                // de sus revisiones.
                muestraDatos("Aviones y mecánicos por revisión", revisionRepository.revisionesAvionMecanico());

                // Dado el nombre de una ciudad y una fecha, listado de los vuelos que han
                // despegado (origen)
                // en los aeropuertos de esa ciudad en esa fecha, ordenados por hora.
                String ciudad = "Madrid";
                String fecha = "29/04/2020";
                muestraDatos("Listado de vuelos desde " + ciudad + " el " + fecha,
                                vueloRepository.vuelosCiudadFecha(ciudad, fecha));

                // Dado el código de empleado de un tripulante, mostrar su nombre y apellidos
                // y las ciudades desde las que ha despegado junto con la fecha en que despegó.
                String codigoTripulante = "00002";
                Tripulante t = tripulanteRepository.findByCodigo(codigoTripulante);
                muestraDatos("Despegues de " + t.getNombre() + " " + t.getApellidos(),
                                tripulanteRepository.despeguesFecha(t.getId()));

                // Para cada tripulante, mostrar su nombre y apellidos junto con su número total
                // de vuelos y la suma de horas de estos.
                muestraDatos("Total de vuelos y suma de horas por tripulante",
                                tripulanteRepository.vuelosHorasPorTripulante());

                // Datos mongodb
                provinciasRepository.findAll();
        }

        

        private static void muestraDatos(String titulo, List datos) {
                System.out.println(titulo);
                System.out.println("-----------------------------------------");
                datos.forEach(System.out::println);
                System.out.println();

        }

}
