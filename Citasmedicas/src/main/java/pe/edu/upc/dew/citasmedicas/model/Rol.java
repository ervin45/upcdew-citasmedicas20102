package pe.edu.upc.dew.citasmedicas.model;

public class Rol {
    private Integer idRol;
    private String rol;

    public Rol(Integer idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

}
