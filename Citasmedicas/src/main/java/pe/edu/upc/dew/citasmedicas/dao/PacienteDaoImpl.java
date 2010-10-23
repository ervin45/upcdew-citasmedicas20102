/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

/**
 *
 * @author cdiaz
 */
public class PacienteDaoImpl extends MainDaoImpl implements PacienteDao {

    public Paciente obtenerPaciente(String idUsuario) {
        Paciente bean = null;
        List<Paciente> lista = bd.getListaPaciente();

        for (Paciente bean_ : lista) {
            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }

    public void registrarPaciente(Paciente paciente) {
        paciente.getUsuario().setRol(bd.getListaRol().get(0));
        bd.getListaUsuario().add(paciente.getUsuario());
        paciente.setIdPersona(bd.getListaPaciente().size() + 1);
        bd.getListaPaciente().add(paciente);
    }

    public List<Paciente> obtenerPacientes() {
        return bd.getListaPaciente();
    }
}
