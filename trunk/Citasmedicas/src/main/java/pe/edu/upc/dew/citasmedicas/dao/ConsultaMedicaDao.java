package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

public interface ConsultaMedicaDao {
    public List<ConsultaMedica> getConsultaMedicaPorFecha(String fechaInicio, String fechaFin);
    public List<ConsultaMedica> getConsultaMedicaPorFechaPorPaciente(Integer idPaciente, String fechaInicio, String fechaFin);
}


