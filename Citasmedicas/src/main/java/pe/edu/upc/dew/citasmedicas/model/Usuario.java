package pe.edu.upc.dew.citasmedicas.model;

public class Usuario {

    //Relacion
    private Rol rol;

    //Atributos
    private String usuario;
    private String password;
    private String estado; // A (Activo) , I (Inactivo)
    private String idRol;  //relacion con la tabla de roles
    
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstado() {
        return estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }
    


}
