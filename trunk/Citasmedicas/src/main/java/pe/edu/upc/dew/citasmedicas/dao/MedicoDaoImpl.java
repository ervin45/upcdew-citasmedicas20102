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
import pe.edu.upc.dew.citasmedicas.model.Especialidad;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public class MedicoDaoImpl extends MainDaoImpl implements MedicoDao {

    public Medico obtenerMedico(String idUsuario) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Especialidad especialidad = new Especialidad(rs.getInt("IdEspecialidad"), rs.getString("NombreEspecialidad"), rs.getString("Estado"));
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombreRol"));
                usuario.setRol(rol);
                Medico empleado = new Medico(rs.getInt("idPersona"), rs.getString("nombre"), rs.getString("apePaterno"), rs.getString("apeMaterno"), rs.getString("sexo"), rs.getString("telefono"), rs.getString("celular"), rs.getString("fechaNacimiento"), rs.getString("documentoIdentidad"), rs.getString("estado"), usuario, especialidad, rs.getString("institucionEstudios"), rs.getString("titulo"));
                return empleado;
            }
        };
        String sql = "SELECT b.*, d.idRol, d.nombre as nombreRol,e.IdEspecialidad, e.ESPECIALIDAD as nombreEspecialidad,a.institucionEstudios,a.TITULO FROM medico a, persona b, usuario x, rol d, especialidad e where a.idPersona = b.idPersona and b.idUsuario = x.idUsuario and x.idRol = d.idRol and a.idespecialidad = e.idespecialidad and b.IdUsuario = ?";

        List parameters = new ArrayList();
        parameters.add(idUsuario);

        List<Medico> list = ((List<Medico>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        Medico bean = null;
//        List<Medico> lista = bd.getListaMedico();
//
//        for (Medico bean_ : lista) {
//            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }
}
