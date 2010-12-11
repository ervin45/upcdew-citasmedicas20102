/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.Especialidad;
import pe.edu.upc.dew.citasmedicas.model.HorarioAtencion;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

/**
 *
 * @author
 */
public class ConsultaMedicaDaoImpl extends MainDaoImpl implements ConsultaMedicaDao {

    public void registrarCita(ConsultaMedica cita) {
        int codigo = (Integer) this.jdbcTemplate.queryForObject("SELECT MAX(IdConsulta) from consultamedica ", Integer.class);
        cita.setIdConsulta(codigo + 1);
        this.jdbcTemplate.update("INSERT INTO consultamedica (IdConsulta,IdMedico,IdPaciente,IdEspecialidad,FechaRegistro,FechaAtencion,HoraInicio,HoraFin) "
                + " VALUES (?,?,?,?,?,?,?,?)",
                new Object[]{
                    new Integer(cita.getIdConsulta()),
                    new Integer(cita.getMedico().getIdPersona()),
                    new Integer(cita.getPaciente().getIdPersona()),
                    new Integer(cita.getEspecialidad().getIdEspecialidad()),
                    cita.getFechaRegistro(),
                    cita.getFechaAtencion(),
                    cita.getHoraInicio(),
                    cita.getHoraFin()
                });
//        bd.getListaConsultaMedica().add(consulta);
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
        int codigo = (Integer) this.jdbcTemplate.queryForObject("SELECT (case when MAX(IdConsulta) is null then 0 else max(idconsulta) end) as codigo from consultamedica ", Integer.class);
        cita.setIdConsulta(codigo + 1);
        this.jdbcTemplate.update("INSERT INTO consultamedica (IdConsulta,IdMedico,IdPaciente,IdEspecialidad,FechaRegistro,FechaAtencion,HoraInicio,HoraFin) "
                + " VALUES (?,?,?,?,?,?,?,?)",
                new Object[]{
                    new Integer(cita.getIdConsulta()),
                    new Integer(cita.getMedico().getIdPersona()),
                    new Integer(cita.getPaciente().getIdPersona()),
                    new Integer(cita.getEspecialidad().getIdEspecialidad()),
                    cita.getFechaRegistro(),
                    cita.getFechaAtencion(),
                    cita.getHoraInicio(),
                    cita.getHoraFin()
                });
//        cita.setIdConsulta(bd.getListaConsultaMedica().size() + 1);
//        bd.getListaConsultaMedica().add(cita);
    }

    public void registrarDiagnostico(ConsultaMedica consulta) {
        this.jdbcTemplate.update("UPDATE consultamedica SET Diagnostico = ? WHERE IdConsulta = ? ",
                new Object[]{
                    new String(consulta.getDiagnostico()),
                    new Integer(consulta.getIdConsulta())
                });
    }

    public List<ConsultaMedica> obtenerCitas(Integer idPaciente) {

        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultaMedica consulta = new ConsultaMedica();
                consulta.setIdConsulta(rs.getInt("IdConsulta"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setHoraInicio(rs.getString("HoraInicio"));
                consulta.setHoraFin(rs.getString("HoraFin"));
                Paciente paciente = new Paciente();
                paciente.setIdPersona(rs.getInt("IdPaciente"));
                paciente.setNombre(rs.getString("nombrePaciente"));
                Medico medico = new Medico();
                medico.setIdPersona(rs.getInt("IdMedico"));
                medico.setNombre(rs.getString("nombreMedico"));
                Especialidad especialidad = new Especialidad(rs.getInt("IdEspecialidad"), rs.getString("nombreespecialidad"));
                consulta.setEspecialidad(especialidad);
                consulta.setMedico(medico);
                consulta.setPaciente(paciente);
                return consulta;
            }
        };
        String sql = "SELECT a.*, b.nombre as nombreMedico, x.nombre as nombrePaciente, d.especialidad as nombreespecialidad FROM consultamedica a, persona b, persona x, especialidad d where a.IDMEDICO = b.IDPERSONA and a.IDPACIENTE = x.idpersona and a.IDESPECIALIDAD = d.IDESPECIALIDAD and x.idPersona = ?";
        List parameters = new ArrayList();
        parameters.add(idPaciente);

        List<ConsultaMedica> list = ((List<ConsultaMedica>) jdbcTemplate.query(sql, parameters.toArray(), mapper));

        return list;

//
//        List<ConsultaMedica> lista = new ArrayList<ConsultaMedica>();
//        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
//            if (bean.getPaciente().getIdPersona().equals(idPaciente)) {
//                lista.add(bean);
//            }
//        }
//        return lista;
    }

    public ConsultaMedica obtenerCita(Integer idCita) {

        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultaMedica consulta = new ConsultaMedica();
                consulta.setIdConsulta(rs.getInt("IdConsulta"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setHoraInicio(rs.getString("HoraInicio"));
                consulta.setHoraFin(rs.getString("HoraFin"));
                Paciente paciente = new Paciente();
                paciente.setIdPersona(rs.getInt("IdPaciente"));
                paciente.setNombre(rs.getString("nombrePaciente"));
                Medico medico = new Medico();
                medico.setIdPersona(rs.getInt("IdMedico"));
                medico.setNombre(rs.getString("nombreMedico"));
                Especialidad especialidad = new Especialidad(rs.getInt("IdEspecialidad"), rs.getString("nombreespecialidad"));
                consulta.setEspecialidad(especialidad);
                consulta.setMedico(medico);
                consulta.setPaciente(paciente);
                return consulta;
            }
        };
        String sql = "SELECT a.*, b.nombre as nombreMedico, x.nombre as nombrePaciente, d.especialidad as nombreespecialidad FROM consultamedica a, persona b, persona x, especialidad d where a.IDMEDICO = b.IDPERSONA and a.IDPACIENTE = x.idpersona and a.IDESPECIALIDAD = d.IDESPECIALIDAD and a.IdConsulta = ?";
        List parameters = new ArrayList();
        parameters.add(idCita);

        List<ConsultaMedica> list = ((List<ConsultaMedica>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
//            if (bean.getIdConsulta().equals(idCita)) {
//                return bean;
//            }
//        }
//        return null;

    }

    public List<ConsultaMedica> obtenerCitasDeMedico(Integer idMedico) {

        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                ConsultaMedica consulta = new ConsultaMedica();
                consulta.setIdConsulta(rs.getInt("IdConsulta"));
                consulta.setDiagnostico(rs.getString("diagnostico"));
                consulta.setHoraInicio(rs.getString("HoraInicio"));
                consulta.setHoraFin(rs.getString("HoraFin"));
                Paciente paciente = new Paciente();
                paciente.setIdPersona(rs.getInt("IdPaciente"));
                paciente.setNombre(rs.getString("nombrePaciente"));
                Medico medico = new Medico();
                medico.setIdPersona(rs.getInt("IdMedico"));
                medico.setNombre(rs.getString("nombreMedico"));
                Especialidad especialidad = new Especialidad(rs.getInt("IdEspecialidad"), rs.getString("nombreEspecialidad"));
                consulta.setEspecialidad(especialidad);
                consulta.setMedico(medico);
                consulta.setPaciente(paciente);
                return consulta;
            }
        };
        String sql = "SELECT a.*, b.nombre as nombreMedico, x.nombre as nombrePaciente, d.especialidad as nombreespecialidad FROM consultamedica a, persona b, persona x, especialidad d where a.IDMEDICO = b.IDPERSONA and a.IDPACIENTE = x.idpersona and a.IDESPECIALIDAD = d.IDESPECIALIDAD and b.idPersona = ?";
        List parameters = new ArrayList();
        parameters.add(idMedico);

        List<ConsultaMedica> list = ((List<ConsultaMedica>) jdbcTemplate.query(sql, parameters.toArray(), mapper));

        return list;
//        List<ConsultaMedica> lista = new ArrayList<ConsultaMedica>();
//        for (ConsultaMedica bean : bd.getListaConsultaMedica()) {
//            if (bean.getMedico().getIdPersona().equals(idMedico)) {
//                lista.add(bean);
//            }
//        }
//        return lista;
    }

    public List<HorarioAtencion> cargarHorario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<HorarioAtencion> cargarHorario(Integer idEspecialidad) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Medico medico = new Medico();
                medico.setIdPersona(rs.getInt("IdMedico"));
                medico.setNombre(rs.getString("nombreMedico"));
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombre(rs.getString("nombreespecialidad"));
                medico.setEspecialidad(especialidad);
                HorarioAtencion horario = new HorarioAtencion(rs.getInt("IdHorario"),rs.getString("HoraInicio"),rs.getString("HoraFin"),medico);
                return horario;
            }
        };
        String sql = "SELECT a.*,  d.NOMBRE as nombreMedico,x.idEspecialidad,x.especialidad as nombreespecialidad FROM HorarioAtencion a, medico b, especialidad x, persona d where a.idmedico = b.IDPERSONA and b.IDPERSONA = d.IDPERSONA and b.IDESPECIALIDAD = x.IDESPECIALIDAD and x.idEspecialidad = ?";
        List parameters = new ArrayList();
        parameters.add(idEspecialidad);

        List<HorarioAtencion> list = ((List<HorarioAtencion>) jdbcTemplate.query(sql, parameters.toArray(), mapper));

        return list;
//        List<HorarioAtencion> lista = new ArrayList<HorarioAtencion>();
//        for (HorarioAtencion bean : bd.getListaHorario()) {
//            if (bean.getMedico().getEspecialidad().getIdEspecialidad().equals(idEspecialidad)) {
//                lista.add(bean);
//            }
//        }
//        return lista;
    }

    public HorarioAtencion obtenerHorario(Integer idHorario) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Medico medico = new Medico();
                medico.setIdPersona(rs.getInt("IdMedico"));
                medico.setNombre(rs.getString("nombreMedico"));
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("idEspecialidad"));
                especialidad.setNombre(rs.getString("nombreespecialidad"));
                medico.setEspecialidad(especialidad);
                HorarioAtencion horario = new HorarioAtencion(rs.getInt("IdHorario"),rs.getString("HoraInicio"),rs.getString("HoraFin"),medico);
                return horario;
            }
        };
        String sql = "SELECT a.*, d.NOMBRE as nombreMedico,x.idEspecialidad,x.especialidad as nombreespecialidad  FROM HorarioAtencion a, medico b, especialidad x, persona d where a.idmedico = b.IDPERSONA and b.IDPERSONA = d.IDPERSONA and b.IDESPECIALIDAD = x.IDESPECIALIDAD and a.idHorario = ?";
        List parameters = new ArrayList();
        parameters.add(idHorario);

        List<HorarioAtencion> list = ((List<HorarioAtencion>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        HorarioAtencion bean = null;
//        for (HorarioAtencion bean_ : bd.getListaHorario()) {
//            if (bean_.getIdHorario().equals(idHorario)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }
}
