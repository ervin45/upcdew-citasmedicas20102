/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.dao;

import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author
 */
public interface UsuarioDao {

    Usuario validarUsuario(String login, String password);

    Usuario validarLogin(String login);
}
