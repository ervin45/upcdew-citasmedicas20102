package pe.edu.upc.dew.citasmedicas.model;

public class Especialidad {
    private String idEspecialidad;
    private String especialidad;
    private String estado;

    public Especialidad(String idEspecialidad, String especialidad, String estado) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Especialidad(String idEspecialidad, String especialidad) {
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdEspecialidad() {
        return idEspecialidad;
    }

}


