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

        @Override
        public void run(String... args) throws Exception {

                // // Recupera productos
                // List<Producto> productos = repository.findAll();
                // System.out.println("Productos con findAll():");
                // System.out.println("----------------------------------------");
                // productos.forEach(System.out::println);

                // Apartado 1: estructura

                // --- Carga de datos
                cargaDatos();

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
        }

        private void cargaDatos() throws ParseException {
                // Aviones:
                Avion av1 = new Avion("1111", "Airbus", "A320", 5000);
                Avion av2 = new Avion("2222", "Airbus", "A330", 10000);
                Avion av3 = new Avion("3333", "Airbus", "A380", 15000);
                Avion av4 = new Avion("4444", "Boeing", "737", 20000);
                Avion av5 = new Avion("5555", "Boeing", "747", 50000);
                avionRepository.saveAll(Arrays.asList(av1, av2, av3, av4, av5));

                // Aeropuerto:
                Aeropuerto ap1 = new Aeropuerto("MAD", "Adolfo Suárez Madrid Barajas", "España", "Madrid");
                Aeropuerto ap2 = new Aeropuerto("BCN", "El Plat", "España", "Barcelona");
                Aeropuerto ap3 = new Aeropuerto("DUB", "Aeropuerto Dublin", "Irlanda", "Dublin");
                Aeropuerto ap4 = new Aeropuerto("SVQ", "Aeropuerto Sevilla", "España", "Sevilla");
                Aeropuerto ap5 = new Aeropuerto("SCQ", "Aeropuerto Santiago", "España", "Lavacolla");
                aeropuertoRepository.saveAll(Arrays.asList(ap1, ap2, ap3, ap4, ap5));

                // Tripulantes:
                Tripulante t1 = new Tripulante("00001", "Pedro", "García", "Auxiliar", "Iberia");
                Tripulante t2 = new Tripulante("00002", "María", "Pérez", "Piloto", "Iberia");
                Tripulante t3 = new Tripulante("00003", "Ana", "López", "Comandante", "Iberia");
                Tripulante t4 = new Tripulante("00004", "Juan", "Blas", "Piloto", "Vueling");
                Tripulante t5 = new Tripulante("00005", "Andrés", "Martínez", "Auxiliar", "Vueling");

                // Vuelos:
                Vuelo v1 = new Vuelo("IB111", "Iberia", av1, ap1, ap2,
                                new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2020"), 0.5);
                List<TripulanteVuelo> trip1 = Arrays.asList(new TripulanteVuelo(t1, v1), new TripulanteVuelo(t2, v1));
                v1.setTripulantes(trip1);
                Vuelo v2 = new Vuelo("IB222", "Iberia", av2, ap3, ap4,
                                new SimpleDateFormat("dd/MM/yyyy").parse("05/12/2020"), 2.5);
                List<TripulanteVuelo> trip2 = Arrays.asList(new TripulanteVuelo(t2, v2), new TripulanteVuelo(t3, v2));
                v2.setTripulantes(trip2);
                Vuelo v3 = new Vuelo("VU111", "Vueling", av5, ap4, ap5,
                                new SimpleDateFormat("dd/MM/yyyy").parse("05/02/2021"), 1.5);
                List<TripulanteVuelo> trip3 = Arrays.asList(new TripulanteVuelo(t4, v3), new TripulanteVuelo(t5, v3));
                v3.setTripulantes(trip3);
                vueloRepository.saveAll(Arrays.asList(v1, v2, v3));

                // Mecánicos y revisiones
                Mecanico m1 = new Mecanico("1000", "Alexis", "Ramos", "Empresa 1", 2005, "FP");
                Mecanico m2 = new Mecanico("2000", "Rafa", "Marquez", "Empresa 2", 2015, "Ninguna");
                Mecanico m3 = new Mecanico("3000", "María", "Pérez", "Empresa 3", 2010, "Ingeniería");
                Mecanico m4 = new Mecanico("4000", "Adela", "López", "Empresa 1", 2019, "FP");
                Mecanico m5 = new Mecanico("5000", "Ramón", "Ronda", "Empresa 2", 2005, "FP");
                mecanicoRepository.saveAll(Arrays.asList(m1, m2, m3, m4, m5));

                Revision r1 = new Revision(av1,
                                new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2019"),
                                new SimpleDateFormat("dd/MM/yyyy").parse("30/04/2019"),
                                150, m1, "Revisión", "Descripción 1", ap1);
                Revision r2 = new Revision(av2,
                                new SimpleDateFormat("dd/MM/yyyy").parse("12/10/2020"),
                                new SimpleDateFormat("dd/MM/yyyy").parse("15/11/2020"),
                                500, m1, "Avería", "Descripción 2", ap1);
                Revision r3 = new Revision(av5,
                                new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2015"),
                                new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2015"),
                                200, m2, "Revisión", "Descripción 3", ap2);
                Revision r4 = new Revision(av5,
                                new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019"),
                                new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"),
                                600, m3, "Revisión", "Descripción 4", ap2);
                revisionRepository.saveAll(Arrays.asList(r1, r2, r3, r4));

        }

        private static void muestraDatos(String titulo, List datos) {
                System.out.println(titulo);
                System.out.println("-----------------------------------------");
                datos.forEach(System.out::println);
                System.out.println();

        }

}
