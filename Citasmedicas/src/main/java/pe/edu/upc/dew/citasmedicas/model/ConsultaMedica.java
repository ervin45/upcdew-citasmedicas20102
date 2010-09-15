package pe.edu.upc.dew.citasmedicas.model;

import java.util.Date;

public class ConsultaMedica {
    //Relacion
    private Paciente paciente;
    private Medico medico;
    private Especialidad especialidad;

    //Atributos
    private Integer idConsulta;
    private Date fechaRegistro;
    private Date fechaAtencion;
    private Integer orden;
    private String comentario;
    private String diagnostico;
    private String recetaMedica;
    private String estado; //Reservado; En Proceso; Cancelada

    public ConsultaMedica(){
    }

    public ConsultaMedica(Paciente paciente, Medico medico, Especialidad especialidad, Date fechaAtencion, Integer orden, String estado) {
        this.paciente = paciente;
        this.medico = medico;
        this.especialidad = especialidad;
        this.fechaAtencion = fechaAtencion;
        this.orden = orden;
        this.estado = estado;

    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public String getComentario() {
        return comentario;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getRecetaMedica() {
        return recetaMedica;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setRecetaMedica(String recetaMedica) {
        this.recetaMedica = recetaMedica;
    }







}
