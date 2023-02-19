package es.urjc.code.modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codigo;

    private String compania;

    @ManyToOne(optional = false)
    private Avion avion;

    @ManyToOne(optional = false)
    private Aeropuerto origen;

    @ManyToOne(optional = false)
    private Aeropuerto destino;

    private Date fechaSalida;

    private Double duracion;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripulanteVuelo> tripulantes = new ArrayList<>();

    public Vuelo() {}

    public Vuelo(String codigo, String compania, Avion avion, Aeropuerto origen, Aeropuerto destino, Date fechaSalida, Double duracion) {
        this.codigo = codigo;
        this.compania = compania;
        this.avion = avion;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.duracion = duracion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public List<TripulanteVuelo> getTripulantes() {
        return tripulantes;
    }

    public void setTripulantes(List<TripulanteVuelo> tripulantes) {
        this.tripulantes = tripulantes;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "codigo='" + codigo + '\'' +
                ", compania='" + compania + '\'' +
                ", avion=" + this.getAvion().getMatricula() +
                ", origen=" + this.getOrigen().getCiudad() +
                ", destino=" + this.getDestino().getCiudad() +
                ", fechaSalida=" + fechaSalida +
                ", duracion=" + duracion +
                '}';
    }
}
