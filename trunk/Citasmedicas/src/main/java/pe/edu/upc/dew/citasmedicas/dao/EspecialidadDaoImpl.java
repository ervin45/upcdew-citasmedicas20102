/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import pe.edu.upc.dew.citasmedicas.model.Especialidad;

/**
 *
 * @author
 */
public class EspecialidadDaoImpl extends MainDaoImpl implements EspecialidadDao {

    public List<Especialidad> obtenerEspecialidades() {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Especialidad especialidad = new Especialidad(rs.getInt("IdEspecialidad"),rs.getString("Especialidad"),rs.getString("Estado"));
                return especialidad;
            }
        };
        List<Especialidad> list = jdbcTemplate.query("SELECT * FROM especialidad", mapper);

        return list;
//        return bd.getListaEspecialidad();
    }
}
