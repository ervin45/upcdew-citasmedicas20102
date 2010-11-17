/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Empleado;

/**
 *
 * @author
 */
public class EmpleadoDaoImpl extends MainDaoImpl implements EmpleadoDao {

    public Empleado obtenerEmpleado(String idUsuario) {
        Empleado bean = null;
        List<Empleado> lista = bd.getListaEmpleado();

        for (Empleado bean_ : lista) {
            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }
}
