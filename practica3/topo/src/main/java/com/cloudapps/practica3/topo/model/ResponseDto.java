package com.cloudapps.practica3.topo.model;

public class ResponseDto {

    private String id;
    private String landscape;

    public ResponseDto() {
    }

    public ResponseDto(String id, String landscape) {
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

    public void setTitle(String landscape) {
        this.landscape = landscape;
    }

}
