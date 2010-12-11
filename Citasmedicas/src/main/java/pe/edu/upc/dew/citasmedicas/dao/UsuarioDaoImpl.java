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
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public class UsuarioDaoImpl extends MainDaoImpl implements UsuarioDao {

    public Usuario validarUsuario(String login, String password) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdRol(rs.getInt("idRol"));
                usuario.setEstado("A");
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombrerol"));
                usuario.setRol(rol);
                return usuario;
            }
        };
        String sql = "SELECT a.*, b.nombre as nombrerol FROM usuario a, rol b where a.idrol = b.idrol and a.idusuario = ? and a.password = ? ";
        List parameters = new ArrayList();
        parameters.add(login);
        parameters.add(password);

        List<Usuario> list = ((List<Usuario>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        Usuario bean = null;
//        List<Usuario> lista = bd.getListaUsuario();
//
//        for (Usuario bean_ : lista) {
//            if (bean_.getLogin().equals(login) && bean_.getPassword().equals(password)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }

    public Usuario validarLogin(String login) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdRol(rs.getInt("idRol"));
                usuario.setEstado("A");
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombrerol"));
                usuario.setRol(rol);
                return usuario;
            }
        };
        String sql = "SELECT a.*, b.nombre as nombrerol FROM usuario a, rol b where a.idrol = b.idrol and a.idusuario = ? ";
        List parameters = new ArrayList();
        parameters.add(login);

        List<Usuario> list = ((List<Usuario>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        Usuario bean = null;
//        List<Usuario> lista = bd.getListaUsuario();
//
//        for (Usuario bean_ : lista) {
//            if (bean_.getLogin().equals(login)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }
}
