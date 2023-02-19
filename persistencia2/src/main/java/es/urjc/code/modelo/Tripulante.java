package es.urjc.code.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tripulante extends Personal {

    private String puesto;
    private String compania;

    // Relación
    @OneToMany(mappedBy = "tripulante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripulanteVuelo> vuelos = new ArrayList<>();

    public Tripulante() {}

    public Tripulante(String codigo, String nombre, String apellidos, String puesto, String compania) {
        super(codigo, nombre, apellidos);
        this.puesto = puesto;
        this.compania = compania;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public List<TripulanteVuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<TripulanteVuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
