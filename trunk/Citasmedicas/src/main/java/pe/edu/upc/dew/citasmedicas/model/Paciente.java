package pe.edu.upc.dew.citasmedicas.model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona {

    private List<ConsultaMedica> consultasMedicas;
    private String asegurado;
    private String numSeguro;

    public Paciente(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, String fechaNacimiento, Usuario usuario) {
        super(nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Paciente(String nombre, String apePaterno, String apeMaterno, String sexo, String telefono, String celular, String fechaNacimiento, String documentoIdentidad, String estado, Usuario usuario) {
        super(nombre, apePaterno, apeMaterno, sexo, telefono, celular, fechaNacimiento, documentoIdentidad, estado, usuario);

        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Paciente(Persona persona) {
        super(persona.getIdPersona(), persona.getNombre(), persona.getApePaterno(), persona.getApeMaterno(), persona.getSexo());
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Paciente(Integer idPersona) {
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
