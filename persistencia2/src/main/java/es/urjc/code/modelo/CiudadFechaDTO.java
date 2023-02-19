package es.urjc.code.modelo;

import java.util.Date;

public class CiudadFechaDTO {
    String ciudad;
    Date fecha;

    public CiudadFechaDTO(String ciudad, Date fecha) {
        this.ciudad = ciudad;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "CiudadFechaDTO{" +
                "ciudad='" + ciudad + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
