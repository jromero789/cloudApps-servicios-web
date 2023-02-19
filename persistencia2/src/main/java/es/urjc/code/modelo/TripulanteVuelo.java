package es.urjc.code.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class TripulanteVuelo {

// La clave primaria está formada por las dos claves ajenas.

    @EmbeddedId
    private TripulanteVueloId id;

    @ManyToOne
    @MapsId("tripulanteId")
    private Tripulante tripulante;

    @ManyToOne
    @MapsId("vueloId")
    private Vuelo vuelo;

    public TripulanteVuelo() {}

    public TripulanteVuelo(Tripulante tripulante, Vuelo vuelo) {
        this.tripulante = tripulante;
        this.vuelo = vuelo;
        // Creación de clave compuesta
        this.id = new TripulanteVueloId(tripulante.getId(), vuelo.getId());
    }


    public Tripulante getTripulante() {
        return tripulante;
    }

    public void setTripulante(Tripulante tripulante) {
        this.tripulante = tripulante;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
