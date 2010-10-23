package pe.edu.upc.dew.citasmedicas.model;

import java.util.Date;

public class Empleado extends Persona {

    private String tipoEmpleado;

    public Empleado(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, Usuario usuario) {
        super(idPersona, nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
    }

    public Empleado(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, Usuario usuario, String tipoEmpleado) {
        super(idPersona, nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
        this.tipoEmpleado = tipoEmpleado;
    }

    public Empleado(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, String idUsuario, String tipoEmpleado) {
        super(idPersona, nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, idUsuario);
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
}
