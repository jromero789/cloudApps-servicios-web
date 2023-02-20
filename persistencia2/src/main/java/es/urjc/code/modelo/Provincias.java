package es.urjc.code.modelo;

import java.util.List;

import jakarta.persistence.Id;

public class Provincias {
    @Id
	private String id;
	private String nombre;
	private String ca;
	private int superficie;
	private List<String> datos;

	// Constructor vacío necesario para Spring
	public Provincias() {
	}
	
	public Provincias(String nombre, String ca, int superficie, List<String> datos) {
		this.nombre = nombre;
		this.ca = ca;
		this.superficie = superficie;
		this.datos = datos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public List<String> getDatos() {
		return datos;
	}

	public void setDatos(List<String> datos) {
		this.datos = datos;
	}

	@Override
    public String toString() {
        return String.format(
                "Provincias[id=%s, nombre='%s', ca='%s', superficie='%s', datos='%s']",
                id, nombre, ca, superficie, datos);
    }

	
}

