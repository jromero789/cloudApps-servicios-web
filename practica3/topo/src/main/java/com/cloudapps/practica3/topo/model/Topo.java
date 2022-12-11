package com.cloudapps.practica3.topo.model;

import org.springframework.data.annotation.Id;

public class Topo {
    
    @Id
    private String id;

    private String city;
    private String landscape;

    public Topo() {
	}

	public Topo(String city, String landscape) {
		super();
		this.city = city;
		this.landscape = landscape;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandscape() {
		return landscape;
	}

	public void setLandscape(String landscape) {
		this.landscape = landscape;
	}
}
