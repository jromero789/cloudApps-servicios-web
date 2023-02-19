package es.urjc.code.modelo;


import jakarta.persistence.*;
import java.util.List;

/**
 * Entidad Mecánico.
 *
 * @author J. Manuel Colmenar.
 */
@Entity
public class Mecanico extends Personal {

    private String empresa;
    private int anio;

    private String formacion;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="mecanicoEncargado")
    private List<Revision> revisiones;

    public Mecanico() {};

    public Mecanico(String codigo, String nombre, String apellidos, String empresa, int anio, String formacion) {
        super(codigo, nombre, apellidos);
        this.empresa = empresa;
        this.anio = anio;
        this.formacion = formacion;
    }

    public Mecanico(String codigo, String nombre, String apellidos, String empresa, int anio, String formacion, List<Revision> revisiones) {
        super(codigo, nombre, apellidos);
        this.empresa = empresa;
        this.anio = anio;
        this.formacion = formacion;
        this.revisiones = revisiones;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


    public List<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }


}
