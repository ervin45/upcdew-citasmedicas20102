/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Especialidad;

/**
 *
 * @author cdiaz
 */
public class EspecialidadDaoImpl extends MainDaoImpl implements EspecialidadDao {

    public List<Especialidad> obtenerEspecialidades() {
        return bd.getListaEspecialidad();
    }
}
