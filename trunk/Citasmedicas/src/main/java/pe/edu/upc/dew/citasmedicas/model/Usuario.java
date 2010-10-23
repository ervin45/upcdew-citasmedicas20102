package pe.edu.upc.dew.citasmedicas.model;

public class Usuario {

    private String login;
    private String password;
    private String estado; // A (Activo) , I (Inactivo)
    private Integer idRol;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(String login, String password, String estado, Integer idRol) {
        this.login = login;
        this.password = password;
        this.estado = estado;
        this.idRol = idRol;
    }

    public Usuario(String login, String password, String estado, Rol rol) {
        this.login = login;
        this.password = password;
        this.estado = estado;
        this.rol = rol;
    }

    public Usuario(String login, String password, String estado) {
        this.login = login;
        this.password = password;
        this.estado = estado;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
