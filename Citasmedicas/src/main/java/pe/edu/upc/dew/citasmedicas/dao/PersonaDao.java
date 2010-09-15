/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.citasmedicas.dao;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Persona;

/**
 *
 * @author REQUEJOW
 */
public interface PersonaDao {
    public Persona getPersonaPorIdPersona(String userName, String password);
    public Persona insertarPersona(Persona persona);
    public int IdMaximoPersona();
}
