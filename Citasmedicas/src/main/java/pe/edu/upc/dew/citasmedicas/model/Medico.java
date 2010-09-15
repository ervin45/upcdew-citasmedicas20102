package pe.edu.upc.dew.citasmedicas.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Medico extends Persona{

    //Relaciones
    private List<ConsultaMedica> consultasMedicas;
    private List<HorarioAtencion> horariosAtencion;
    private Especialidad especialidad;
    private String institucionEstudios;
    private String titulo;


    public Medico(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo, String estado, Date fechaNacimiento, Usuario usuario) {
        super(nombre, apePaterno, apeMaterno, sexo, estado, fechaNacimiento, usuario);
        this.consultasMedicas = new ArrayList<ConsultaMedica>();
    }

    public Medico(Integer idPersona, String nombre, String apePaterno, String apeMaterno, String sexo) {
        super(idPersona, nombre, apePaterno, apeMaterno, sexo);
    }

    public List<ConsultaMedica> getConsultasMedicas() {
        return consultasMedicas;
    }

    public void setConsultasMedicas(List<ConsultaMedica> consultasMedicas) {
        this.consultasMedicas = consultasMedicas;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<HorarioAtencion> getHorariosAtencion() {
        return horariosAtencion;
    }

    public void setHorariosAtencion(List<HorarioAtencion> horariosAtencion) {
        this.horariosAtencion = horariosAtencion;
    }

    public String getInstitucionEstudios() {
        return institucionEstudios;
    }

    public void setInstitucionEstudios(String institucionEstudios) {
        this.institucionEstudios = institucionEstudios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
