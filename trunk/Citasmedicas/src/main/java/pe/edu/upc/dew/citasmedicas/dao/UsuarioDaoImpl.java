/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public class UsuarioDaoImpl extends MainDaoImpl implements UsuarioDao {

    public Usuario validarUsuario(String login, String password) {
        Usuario bean = null;
        List<Usuario> lista = bd.getListaUsuario();

        for (Usuario bean_ : lista) {
            if (bean_.getLogin().equals(login) && bean_.getPassword().equals(password)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }

    public Usuario validarLogin(String login) {
        Usuario bean = null;
        List<Usuario> lista = bd.getListaUsuario();

        for (Usuario bean_ : lista) {
            if (bean_.getLogin().equals(login)) {
                bean = bean_;
                break;
            }
        }
        return bean;
    }
}
