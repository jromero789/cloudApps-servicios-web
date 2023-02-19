package es.urjc.code.modelo;


import jakarta.persistence.*;
import java.util.Date;

/**
 * Entidad Revisión.
 *
 * @author J. Manuel Colmenar.
 */
@Entity
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Avion avion;
    private Date fechaInicio;
    private Date fechaFin;
    private double horasMecanico;
    @ManyToOne
    private Mecanico mecanicoEncargado;
    private String tipoRevision;
    private String descripcion;
    @ManyToOne
    private Aeropuerto aeropuerto;

    public Revision() {};

    public Revision(Avion avion, Date fechaInicio, Date fechaFin, double horasMecanico, Mecanico mecanicoEncargado, String tipoRevision, String descripcion, Aeropuerto aeropuerto) {
        this.avion = avion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horasMecanico = horasMecanico;
        this.mecanicoEncargado = mecanicoEncargado;
        this.tipoRevision = tipoRevision;
        this.descripcion = descripcion;
        this.aeropuerto = aeropuerto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getHorasMecanico() {
        return horasMecanico;
    }

    public void setHorasMecanico(double horasMecanico) {
        this.horasMecanico = horasMecanico;
    }

    public Mecanico getMecanicoEncargado() {
        return mecanicoEncargado;
    }

    public void setMecanicoEncargado(Mecanico mecanicoEncargado) {
        this.mecanicoEncargado = mecanicoEncargado;
    }

    public String getTipoRevision() {
        return tipoRevision;
    }

    public void setTipoRevision(String tipoRevision) {
        this.tipoRevision = tipoRevision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", horasMecanico=" + horasMecanico +
                ", tipoRevision='" + tipoRevision + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", mecanicoEncargado=" + mecanicoEncargado +
                ", aeropuerto=" + aeropuerto +
                ", avion=" + avion +
                '}';
    }
}

