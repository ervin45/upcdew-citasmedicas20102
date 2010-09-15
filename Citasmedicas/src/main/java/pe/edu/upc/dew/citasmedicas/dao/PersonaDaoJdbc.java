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

import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Persona;
import pe.edu.upc.dew.citasmedicas.model.Usuario;
import pe.edu.upc.dew.citasmedicas.dao.JdbcUtils;
/**
 *
 * @author REQUEJOW
 */
public class PersonaDaoJdbc implements PersonaDao{
@Override
    public Persona getPersonaPorIdPersona(String userName, String password) {
        Persona persona=null;
        Usuario usuario;
        usuario = new Usuario();
        usuario.setUsuario(userName);
        usuario.setPassword(password);
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();
          final String query = "select IdPersona,nombre,apePaterno,sexo,telefono,celular,fechaNacimiento,documentoIdentidad,P.Estado,U.idRol from persona P inner join Usuario U ON P.idusuario = U.usuario and U.usuario='" + userName + "' and U.password ='" + password +"'" ;
          rs = st.executeQuery(query);

          while (rs.next()) {
            usuario.setIdRol(rs.getString(10));
            persona = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), usuario);       
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
        return persona;
    }

    @Override
    public Persona insertarPersona(Persona persona) {
        String cmdCliente;
        int idPersona=0;
      //  PreparedStatement pstm;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            idPersona = this.IdMaximoPersona()+1;
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            cmdCliente = "insert into persona (IdPersona,nombre,apePaterno,apeMaterno,sexo,telefono,celular,fechanacimiento,documentoidentidad,estado,idusuario) values ( ?,?,?,?,?,?,?,?,?,?,? )";
//            pstm = (PreparedStatement) connection.prepareStatement(cmdCliente);
//            pstm.setInt(1, idPersona );
//            pstm.setString(2, persona.getNombre());
//            pstm.setString(3, persona.getApePaterno());
//            pstm.setString(4, persona.getApeMaterno());
//            pstm.setString(5, persona.getSexo());
//            pstm.setString(6, persona.getTelefono());
//            pstm.setString(7, persona.getCelular());
            //pstm.setDate(8, persona.getFechaNacimiento());
//            pstm.setDate(8,null);
//            pstm.setString(9, persona.getDocumentoIdentidad());
//            pstm.setString(10, persona.getEstado());
//            pstm.setString(11, persona.getUsuario().getUsuario());
//            pstm.executeUpdate();

            cmdCliente = "insert into usuario (usuario,password,estado,idrol) values ( ?,?,?,? )";
//            pstm = (PreparedStatement) connection.prepareStatement(cmdCliente);
//            pstm.setString(1, persona.getUsuario().getUsuario());
//            pstm.setString(2, persona.getUsuario().getPassword());
//            pstm.setString(3, "A");
//            pstm.setString(4, "PA");
//            pstm.executeUpdate();
            
        } catch (SQLException e) {
            throw new IllegalStateException("Error al actualizar el persona", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }

        return persona;

    }

    @Override
    public int IdMaximoPersona() {
        int maximo=0;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
          connection = JdbcUtils.getConnection();
          st = connection.createStatement();
          final String query = "select Max(IdPersona) from persona" ;
          rs = st.executeQuery(query);
          while (rs.next()) {
            maximo = rs.getInt(1);
          }
      }
      catch (SQLException e) {
        throw new IllegalStateException("Error al obtener la numero de persona", e);
      }
      finally {
          JdbcUtils.closeResultSet(rs);
          JdbcUtils.closeStatement(st);
          JdbcUtils.closeConnection(connection);
      }
        return maximo;
    }
    
}
