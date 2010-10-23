package pe.edu.upc.dew.citasmedicas.model;

public class Especialidad {
    private Integer idEspecialidad;
    private String nombre;
    private String estado;

    public Especialidad(Integer idEspecialidad, String nombre, String estado) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Especialidad(Integer idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}


