package pe.edu.upc.dew.citasmedicas.model;

import java.util.Date;

public abstract class Persona {

    private Integer idPersona;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String sexo;
    private String telefono;
    private String celular;
    private String fechaNacimiento;
    private String documentoIdentidad;
    private String estado;
    private String idUsuario;
    private Usuario usuario;

    public Persona() {
    }

    public Persona(String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, Usuario usuario) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Persona(String nombre, String apePaterno, String apeMaterno, String sexo, String telefono, String celular, String fechaNacimiento, String documentoIdentidad, String estado, Usuario usuario) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.documentoIdentidad = documentoIdentidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Persona(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String telefono, String celular, String fechaNacimiento, String documentoIdentidad, String estado, Usuario usuario) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.telefono = telefono;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
        this.documentoIdentidad = documentoIdentidad;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Persona(String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, String idUsuario) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Persona(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, String idUsuario) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Persona(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, Usuario usuario) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.usuario = usuario;
    }

    public Persona(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.sexo = sexo;
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}


