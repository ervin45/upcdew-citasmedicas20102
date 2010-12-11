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
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public class PacienteDaoImpl extends MainDaoImpl implements PacienteDao {

    public Paciente obtenerPaciente(String idUsuario) {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombreRol"));
                usuario.setRol(rol);
                Paciente paciente = new Paciente(rs.getInt("idPersona"),rs.getString("nombre"), rs.getString("apePaterno"), rs.getString("apeMaterno"), rs.getString("sexo"), rs.getString("telefono"), rs.getString("celular"), rs.getString("fechaNacimiento"), rs.getString("documentoIdentidad"), rs.getString("estado"), usuario);
                return paciente;
            }
        };
        String sql = "SELECT b.*, d.idRol, d.nombre as nombreRol FROM paciente a, persona b, usuario x, rol d where a.idPersona = b.idPersona and b.idUsuario = x.idUsuario and x.idRol = d.idRol and b.IdUsuario = ?";
        List parameters = new ArrayList();
        parameters.add(idUsuario);

        List<Paciente> list = ((List<Paciente>) jdbcTemplate.query(sql, parameters.toArray(), mapper));
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
//        Paciente bean = null;
//        List<Paciente> lista = bd.getListaPaciente();
//
//        for (Paciente bean_ : lista) {
//            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
//                bean = bean_;
//                break;
//            }
//        }
//        return bean;
    }

    public void registrarPaciente(Paciente paciente) {
        this.jdbcTemplate.update("INSERT INTO USUARIO (IdUsuario,password,estado,idrol) "
                + " VALUES (?,?,?,?)",
                new Object[]{
                    new String(paciente.getUsuario().getLogin()),
                    new String(paciente.getUsuario().getPassword()),
                    new String("A"),
                    new Integer(1)
                });
        int codigo = (Integer) this.jdbcTemplate.queryForObject("SELECT MAX(idPersona) from persona ", Integer.class);
        this.jdbcTemplate.update("INSERT INTO PERSONA (IdPersona,Nombre,ApePaterno,ApeMaterno,Sexo,Telefono,Celular,FechaNacimiento,DocumentoIdentidad,IdUsuario,Estado) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                new Object[]{
                    new Integer(codigo + 1),
                    paciente.getNombre(),
                    paciente.getApePaterno(),
                    paciente.getApeMaterno(),
                    paciente.getSexo(),
                    paciente.getTelefono(),
                    paciente.getCelular(),
                    paciente.getFechaNacimiento(),
                    paciente.getDocumentoIdentidad(),
                    paciente.getUsuario().getLogin(),
                    paciente.getEstado()
                });
        this.jdbcTemplate.update("INSERT INTO PACIENTE (IdPersona,Asegurado,NumSeguro) "
                + " VALUES (?,?,?)",
                new Object[]{
                    new Integer(codigo + 1),
                    paciente.getAsegurado()==null?"":paciente.getAsegurado(),
                    paciente.getNumSeguro()==null?"":paciente.getNumSeguro()
                });
//        paciente.getUsuario().setRol(bd.getListaRol().get(0));
//        bd.getListaUsuario().add(paciente.getUsuario());
//        paciente.setIdPersona(bd.getListaPaciente().size() + 1);
//        bd.getListaPaciente().add(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        RowMapper mapper = new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("IdUsuario"));
                Rol rol = new Rol();
                rol.setIdRol(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombreRol"));
                usuario.setRol(rol);
                Paciente paciente = new Paciente(rs.getInt("idPersona"),rs.getString("nombre"), rs.getString("apePaterno"), rs.getString("apeMaterno"), rs.getString("sexo"), rs.getString("telefono"), rs.getString("celular"), rs.getString("fechaNacimiento"), rs.getString("documentoIdentidad"), rs.getString("estado"), usuario);
                return paciente;
            }
        };
        String sql = "SELECT b.*, d.idRol, d.nombre as nombreRol FROM paciente a, persona b, usuario x, rol d where a.idPersona = b.idPersona and b.idUsuario = x.idUsuario and x.idRol = d.idRol ";

        List<Paciente> list = jdbcTemplate.query(sql, mapper);

        return list;
    }
}
