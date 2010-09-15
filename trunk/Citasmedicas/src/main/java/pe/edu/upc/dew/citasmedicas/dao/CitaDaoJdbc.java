package pe.edu.upc.dew.citasmedicas.dao;

//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CitaDaoJdbc implements CitaDao {

    @Override
    public Boolean InsertConsultaMedicaPorFecha(String fechaInicio) {

        Boolean grabar = false;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
       // PreparedStatement pstm;

        try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();


         // String query = "insert into consultamedica (IdMedico, IdPaciente, fechaAtencion) values (3,1,str_to_date('" + fechaInicio + "','%d/%m/%Y'))";
         // pstm = (PreparedStatement) connection.prepareStatement(query);
         // pstm.executeUpdate();

          grabar = true;

      }
      catch (SQLException e) {
        throw new IllegalStateException("Error al obtener la consulta", e);
      }
      finally {
          JdbcUtils.closeResultSet(rs);
          JdbcUtils.closeStatement(st);
          JdbcUtils.closeConnection(connection);
      }
      return grabar;

    }

}
