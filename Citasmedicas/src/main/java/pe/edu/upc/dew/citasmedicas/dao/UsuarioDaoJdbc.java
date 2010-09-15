/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.citasmedicas.dao;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 *
 * @author REQUEJOW
 */
public  class UsuarioDaoJdbc implements UsuarioDao {
    @Override
    public int ValidarUsuarioRepetido(String userName) {
        String strUsuario=null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();
          final String query = "select usuario from usuario where usuario ='" + userName + "'" ;
          rs = st.executeQuery(query);
          while (rs.next()) {
            strUsuario = rs.getString(1);
          }
      }
      catch (SQLException e) {
        throw new IllegalStateException("Error al validar persona", e);
      }
      finally {
          JdbcUtils.closeResultSet(rs);
          JdbcUtils.closeStatement(st);
          JdbcUtils.closeConnection(connection);
      }
      if (strUsuario == null){
        return 0;
      }
      else{
        return -1;
      }

    }    
}
