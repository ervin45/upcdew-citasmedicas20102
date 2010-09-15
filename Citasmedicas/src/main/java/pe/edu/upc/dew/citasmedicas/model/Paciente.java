package pe.edu.upc.dew.citasmedicas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Persona;

public class Paciente extends Persona {
    private List<ConsultaMedica> consultasMedicas;
    private String asegurado;
    private String numSeguro;

    public Paciente(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, Date fechaNacimiento, Usuario usuario) {
        super(nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Paciente(Persona persona) {
        super(persona.getIdPersona(), persona.getNombre(), persona.getApePaterno(), persona.getApeMaterno(), persona.getSexo());
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Paciente(Integer idPersona){
        super(idPersona);
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }
    
    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public String getNumSeguro() {
        return numSeguro;
    }

    public void setNumSeguro(String numSeguro) {
        this.numSeguro = numSeguro;
    }

    public List<ConsultaMedica> getConsultasMedicas() {
        return consultasMedicas;
    }

}