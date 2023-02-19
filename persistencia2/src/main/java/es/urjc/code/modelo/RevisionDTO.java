package es.urjc.code.modelo;

public class RevisionDTO {
    private String matriculaAvion;

    private String nombre;

    private String apellidos;

    public RevisionDTO(String matriculaAvion, String nombre, String apellidos) {
        this.matriculaAvion = matriculaAvion;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getMatriculaAvion() {
        return matriculaAvion;
    }

    public void setMatriculaAvion(String matriculaAvion) {
        this.matriculaAvion = matriculaAvion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "RevisionDTO{" +
                "matriculaAvion='" + matriculaAvion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
