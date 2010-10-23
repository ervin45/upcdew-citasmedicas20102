/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Medico;

/**
 *
 * @author cdiaz
 */
public class MedicoDaoImpl extends MainDaoImpl implements MedicoDao {

    public Medico obtenerMedico(String idUsuario) {
        Medico bean = null;
        List<Medico> lista = bd.getListaMedico();

        for (Medico bean_ : lista) {
            if (bean_.getUsuario().getLogin().equals(idUsuario)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }
}
