package es.urjc.code.modelo;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad Avión.
 *
 * @author J. Manuel Colmenar.
 */
@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String matricula;
    private String fabricante;
    private String modelo;
    private long horasVuelo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    private List<Vuelo> vuelos;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="avion")
    private List<Revision> revisiones;

    public Avion() {};

    public Avion(String matricula, String fabricante, String modelo, long horasVuelo) {
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horasVuelo = horasVuelo;
    }

    public Avion(long id, String matricula, String fabricante, String modelo, long horasVuelo, List<Vuelo> vuelos, List<Revision> revisiones) {
        this.id = id;
        this.matricula = matricula;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.horasVuelo = horasVuelo;
        this.vuelos = vuelos;
        this.revisiones = revisiones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setHorasVuelo(long horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public long getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", modelo='" + modelo + '\'' +
                ", horasVuelo=" + horasVuelo +
                ", revisiones=" + revisiones +
                '}';
    }
}
