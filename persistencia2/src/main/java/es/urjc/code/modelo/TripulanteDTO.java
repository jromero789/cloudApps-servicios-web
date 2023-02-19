package es.urjc.code.modelo;

public class TripulanteDTO {
    String nombre;
    String apellidos;
    long numVuelos;
    double sumaHorasVuelos;

    public TripulanteDTO(String nombre, String apellidos, long numVuelos, double sumaHorasVuelos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numVuelos = numVuelos;
        this.sumaHorasVuelos = sumaHorasVuelos;
    }

    @Override
    public String toString() {
        return "TripulanteDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numVuelos=" + numVuelos +
                ", sumaHorasVuelos=" + sumaHorasVuelos +
                '}';
    }
}
