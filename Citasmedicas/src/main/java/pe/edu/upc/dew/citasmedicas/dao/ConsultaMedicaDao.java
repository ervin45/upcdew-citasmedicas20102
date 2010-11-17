/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.HorarioAtencion;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

/**
 *
 * @author
 */
public interface ConsultaMedicaDao {

    void registrarCita(ConsultaMedica consulta);

    void registrarDiagnostico(ConsultaMedica consulta);

    ConsultaMedica obtenerCita(Integer idCita);

    List<ConsultaMedica> obtenerCitas(Integer idPaciente);

    List<ConsultaMedica> obtenerCitasDeMedico(Integer idMedico);

    List<HorarioAtencion> cargarHorario();

    List<HorarioAtencion> cargarHorario(Integer idEspecialidad);

    HorarioAtencion obtenerHorario(Integer idHorario);

    void registrarCita(HorarioAtencion horario, Paciente paciente);
}
