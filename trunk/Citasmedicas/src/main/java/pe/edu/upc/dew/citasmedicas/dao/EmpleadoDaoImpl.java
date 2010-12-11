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
import pe.edu.upc.dew.citasmedicas.model.Empleado;
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public class EmpleadoDaoImpl extends MainDaoImpl implements EmpleadoDao {

    public Empleado obtenerEmpleado(String idUsuario) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombreRol"));
                Empleado empleado = new Empleado(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apePaterno"), rs.getString("apeMaterno"), rs.getString("sexo"), rs.getString("telefono"), rs.getString("celular"), rs.getString("fechaNacimiento"), rs.getString("documentoIdentidad"), rs.getString("estado"), usuario, rs.getString("tipoEmpleado"));
                 return empleado;
            }
        };
        String sql = "SELECT b.*, d.idRol, d.nombre as nombreRol,a.tipoEmpleado FROM empleado a, persona b, usuario x, rol d where a.idPersona = b.idPersona and b.idUsuario = x.idUsuario and x.idRol = d.idRol and b.IdUsuario = ?";
        List parameters = new ArrayList();
        parameters.add(idUsuario);

        List<Empleado> list = ((List<Empleado>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        Empleado bean = null;
//        List<Empleado> lista = bd.getListaEmpleado();
//
//        for (Empleado bean_ : lista) {
//            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }
}
