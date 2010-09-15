/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import pe.edu.upc.dew.citasmedicas.model.Empleado;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Persona;
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;
import java.util.ArrayList;

import pe.edu.upc.dew.citasmedicas.dao.PersonaDaoJdbc;
import pe.edu.upc.dew.citasmedicas.dao.UsuarioDaoJdbc;

/**
 *
 * @author REQUEJOW
 */
public class RegistroPacienteServlet extends HttpServlet {
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("txtUsuario");
        int errorx = -99;
        Usuario usuario = new Usuario();
        //PersonaDaoHibernate personaDao = new PersonaDaoHibernate();
        UsuarioDaoJdbc usuarioDao = new UsuarioDaoJdbc();
        //validar que el correo no exista
        errorx = usuarioDao.ValidarUsuarioRepetido(username);
        if (errorx!=0){
            req.getRequestDispatcher("/registroUsuario.jsp").forward(req, resp) ;
            return;
        }
        //
        PersonaDaoJdbc personaDao = new PersonaDaoJdbc();
        Date fecha = new Date();
        Persona persona;
        
        String password = req.getParameter("txtPassword");
        String documento = req.getParameter("txtdocumento");
        String nombres = req.getParameter("txtNombres");
        String apepat = req.getParameter("txtApellidoPaterno");
        String apemat = req.getParameter("txtApellidoMaterno");
        String sexo = "M";
        String nacimiento = req.getParameter("txtNacimiento");
        String telefono = req.getParameter("txtTelefono");
        String celular = req.getParameter("txtCelular");

        usuario.setEstado("A");
        usuario.setUsuario(username);
        usuario.setPassword(password);
        usuario.setIdRol("PA");
        //usuario.se;
        persona = new Paciente(1, nombres, apepat, apemat,  sexo, "A", fecha, usuario);
        personaDao.insertarPersona(persona);
        HttpSession session = req.getSession();
        session.setAttribute("persona", persona);
        req.getRequestDispatcher("/index.jsp").forward(req, resp) ;
       
   }

}
