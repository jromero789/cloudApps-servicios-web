package es.urjc.code.modelo;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad Aeropuerto.
 *
 * @author J. Manuel Colmenar.
 */
@Entity
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String codigo;
    private String nombre;
    private String ciudad;
    private String pais;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="aeropuerto")
    private List<Revision> revisiones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origen")
    private List<Vuelo> salidas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destino")
    private List<Vuelo> llegadas;


    public Aeropuerto() {};

    public Aeropuerto(String codigo, String nombre, String pais, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    public Aeropuerto(long id, String codigo, String nombre, String ciudad, String pais, List<Revision> revisiones, List<Vuelo> salidas, List<Vuelo> llegadas) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.revisiones = revisiones;
        this.salidas = salidas;
        this.llegadas = llegadas;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public List<Vuelo> getSalidas() {
        return salidas;
    }

    public void setSalidas(List<Vuelo> salidas) {
        this.salidas = salidas;
    }

    public List<Vuelo> getLlegadas() {
        return llegadas;
    }

    public void setLlegadas(List<Vuelo> llegadas) {
        this.llegadas = llegadas;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
