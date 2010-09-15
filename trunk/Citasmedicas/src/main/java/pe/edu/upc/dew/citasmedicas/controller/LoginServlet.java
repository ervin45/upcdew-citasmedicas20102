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


public class LoginServlet extends HttpServlet{

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonaDaoJdbc personaDao = new PersonaDaoJdbc();
        Usuario usuario = new Usuario();
        Date fecha = new Date();
        String rol = null;
        Persona persona;
        String username = req.getParameter("txtUsuario");
        String password = req.getParameter("txtPassword");
        persona = personaDao.getPersonaPorIdPersona(username,password);
        if (persona != null)  {
            HttpSession session = req.getSession();
            session.setAttribute("persona", persona);
            rol = persona.getUsuario().getIdRol();
            //if (rol.equals("PA")){
                req.getRequestDispatcher("/index.jsp").forward(req, resp) ;
                //}
            }
        else{
                System.out.println("El usuario no existe");
                req.getRequestDispatcher("/login.jsp").forward(req, resp) ;
            }    
   }
}
