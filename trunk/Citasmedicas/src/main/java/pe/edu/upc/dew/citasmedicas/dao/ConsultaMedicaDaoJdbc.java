package pe.edu.upc.dew.citasmedicas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.Especialidad;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Persona;

public class ConsultaMedicaDaoJdbc implements ConsultaMedicaDao {

    @Override
    public List<ConsultaMedica> getConsultaMedicaPorFecha(String fechaInicio, String fechaFin) {
      List<ConsultaMedica> loConsultaMedica = null;
      ConsultaMedica consultaMedica = null;
      Medico medico = null;
      Paciente paciente = null;
      Especialidad especialidad = null;


      Connection connection = null;
      Statement st = null;
      ResultSet rs = null;
      
      try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();
          
          final String query = "select es.IdEspecialidad, es.Especialidad, pe.IdPersona as IdPersonaMedico, pe.Nombre as NombreMedico, pe.ApePaterno as ApePaternoMedico, pe.ApeMaterno as ApeMaternoMedico, pe.Sexo as SexoMedico, cm.IdPaciente ,cm.orden, cm.fechaRegistro, cm.Estado from consultamedica cm inner join persona pe on cm.idMedico = pe.idPersona inner join especialidad es on es.idEspecialidad = cm.idEspecialidad where cm.fechaatencion between str_to_date('" + fechaInicio + "','%d/%m/%Y') and str_to_date('" + fechaFin + "','%d/%m/%Y')";

          rs = st.executeQuery(query);
          
          while (rs.next()) {

            
            if (rs.isFirst()){
                loConsultaMedica = new ArrayList<ConsultaMedica>();
            }
            
            consultaMedica = new ConsultaMedica();
            
            especialidad = new Especialidad(rs.getString("IdEspecialidad"), rs.getString("Especialidad"));
            medico = new Medico(rs.getInt("IdPersonaMedico"), rs.getString("NombreMedico"), rs.getString("ApeMaternoMedico"), rs.getString("ApePaternoMedico"), rs.getString("SexoMedico"));
            paciente = new Paciente(rs.getInt("IdPaciente"));
            consultaMedica = new ConsultaMedica(paciente, medico, especialidad, rs.getDate("fechaRegistro"),  rs.getInt("orden"), rs.getString("Estado"));
            loConsultaMedica.add(consultaMedica);
          }          
      }
      catch (SQLException e) {
        throw new IllegalStateException("Error al obtener la consulta", e);
      }
      finally {
          JdbcUtils.closeResultSet(rs);
          JdbcUtils.closeStatement(st);
          JdbcUtils.closeConnection(connection);
      }
      return loConsultaMedica;
    }
    
    @Override
    public List<ConsultaMedica> getConsultaMedicaPorFechaPorPaciente(Integer idPaciente, String fechaInicio, String fechaFin) {
      List<ConsultaMedica> loConsultaMedica = null;
      ConsultaMedica consultaMedica = null;
      Medico medico = null;
      Paciente paciente = null;
      Especialidad especialidad = null;

      Connection connection = null;
      Statement st = null;
      ResultSet rs = null;
      try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();
          String strQuery = "select es.IdEspecialidad, es.Especialidad ";
          strQuery += ", pe.IdPersona as IdPersonaMedico, pe.Nombre as NombreMedico, pe.ApePaterno as ApePaternoMedico, cm.ApeMaterno as ApeMaternoMedico, pe.Sexo as SexoMedico ";
          strQuery += ", cm.IdPaciente ,cm.orden, cm.fechaRegistro, cm.Estado ";
          strQuery += "from consultamedica cm inner join persona pe on cm.idMedico = pe.idPersona ";
          strQuery += "inner join especialidad es on es.idEspecialidad = cm.idEspecialidad ";
          strQuery += "where cm.IdPaciente = " + idPaciente.toString() + " and date_format(cm.fechaatencion,'%d/%m/%Y) between " + fechaInicio + " and " + fechaFin;
          
          final String query = strQuery;
          rs = st.executeQuery(query);
          System.out.println("Ejecucion Query");
          while (rs.next()) {
            consultaMedica = new ConsultaMedica();
            System.out.println(rs.getString("IdEspecialidad"));
            especialidad = new Especialidad(rs.getString("IdEspecialidad"), rs.getString("Especialidad"));
            medico = new Medico(rs.getInt("IdPersonaMedico"), rs.getString("NombreMedico"), rs.getString("ApePaternoMedico"), rs.getString("ApePaternoMedico"), rs.getString("SexoMedico"));
            paciente = new Paciente(rs.getInt("IdPaciente"));
            consultaMedica = new ConsultaMedica(paciente, medico, especialidad, rs.getDate("fechaRegistro"),  rs.getInt("orden"), rs.getString("Estado"));
            loConsultaMedica.add(consultaMedica);
          }
      }
      catch (SQLException e) {
        throw new IllegalStateException("Error al obtener la consulta", e);
      }
      finally {
          JdbcUtils.closeResultSet(rs);
          JdbcUtils.closeStatement(st);
          JdbcUtils.closeConnection(connection);
      }
      return loConsultaMedica;
    }

}
