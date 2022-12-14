package com.cloudapps.practica3.server.topo;

public class TopoDto {

    private String id;
    private String landscape;

    public TopoDto() {
    }

    public TopoDto(String id, String landscape) {
        super();
        this.id = id;
        this.landscape = landscape;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLandscape() {
        return landscape;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

}
