/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.ArrayList;
import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.HorarioAtencion;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

/**
 *
 * @author cdiaz
 */
public class ConsultaMedicaDaoImpl extends MainDaoImpl implements ConsultaMedicaDao {

    public void registrarCita(ConsultaMedica consulta) {
        bd.getListaConsultaMedica().add(consulta);
    }

    public void registrarCita(HorarioAtencion horario, Paciente paciente) {
        ConsultaMedica cita = new ConsultaMedica();
        cita.setPaciente(paciente);
        cita.setMedico(horario.getMedico());
        cita.setEspecialidad(horario.getMedico().getEspecialidad());
        cita.setFechaRegistro(new java.util.Date());
        cita.setFechaAtencion(new java.util.Date());
        cita.setHoraInicio(horario.getHoraInicio());
        cita.setHoraFin(horario.getHoraFin());
        cita.setIdConsulta(bd.getListaConsultaMedica().size() + 1);
        bd.getListaConsultaMedica().add(cita);
    }

    public void registrarDiagnostico(ConsultaMedica consulta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<ConsultaMedica> obtenerCitas(Integer idPaciente) {
        List<ConsultaMedica> lista = new ArrayList<ConsultaMedica>();
        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
            if (bean.getPaciente().getIdPersona().equals(idPaciente)) {
                lista.add(bean);
            }
        }
        return lista;
    }

    public ConsultaMedica obtenerCita(Integer idCita) {
        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
            if (bean.getIdConsulta().equals(idCita)) {
                return bean;
            }
        }
        return null;

    }

    public List<ConsultaMedica> obtenerCitasDeMedico(Integer idMedico) {
        List<ConsultaMedica> lista = new ArrayList<ConsultaMedica>();
        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
            if (bean.getMedico().getIdPersona().equals(idMedico)) {
                lista.add(bean);
            }
        }
        return lista;
    }

    public List<HorarioAtencion> cargarHorario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<HorarioAtencion> cargarHorario(Integer idEspecialidad) {
        List<HorarioAtencion> lista = new ArrayList<HorarioAtencion>();
        for (HorarioAtencion bean : bd.getListaHorario()) {
            if (bean.getMedico().getEspecialidad().getIdEspecialidad().equals(idEspecialidad)) {
                lista.add(bean);
            }
        }
        return lista;
    }

    public HorarioAtencion obtenerHorario(Integer idHorario) {
        HorarioAtencion bean = null;
        for (HorarioAtencion bean_ : bd.getListaHorario()) {
            if (bean_.getIdHorario().equals(idHorario)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }
}
