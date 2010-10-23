/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

/**
 *
 * @author 
 */
public interface PacienteDao {

    Paciente obtenerPaciente(String idUsuario);

    List<Paciente> obtenerPacientes();

    void registrarPaciente(Paciente paciente);
}
