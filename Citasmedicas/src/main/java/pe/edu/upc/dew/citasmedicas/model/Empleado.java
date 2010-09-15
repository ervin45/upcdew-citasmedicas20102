package pe.edu.upc.dew.citasmedicas.model;

import java.util.Date;


public class Empleado extends Persona{

    private String tipoEmpleado;

    public Empleado(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, Date fechaNacimiento, Usuario usuario, String tipoEmpleado) {
        super(nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }



}
