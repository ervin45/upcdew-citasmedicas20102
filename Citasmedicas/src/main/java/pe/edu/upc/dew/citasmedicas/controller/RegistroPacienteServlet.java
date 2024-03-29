/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import pe.edu.upc.dew.citasmedicas.dao.PacienteDao;
import pe.edu.upc.dew.citasmedicas.dao.UsuarioDao;
import pe.edu.upc.dew.citasmedicas.factory.CitasMedicasFactory;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Usuario;

/**
 *
 * @author 
 */
public class RegistroPacienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nombre = req.getParameter("nombre");
        String apePaterno = req.getParameter("apePaterno");
        String apeMaterno = req.getParameter("apeMaterno");
        String sexo = req.getParameter("sexo");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String telefono = req.getParameter("telefono");
        String celular = req.getParameter("celular");
        String documentoIdentidad = req.getParameter("documentoIdentidad");

        if (getUsuarioDao().validarLogin(login) == null) {
            Usuario usuario = new Usuario(login, password, "A");
            Paciente paciente = new Paciente(nombre, apePaterno, apeMaterno, sexo, telefono, celular, fechaNacimiento, documentoIdentidad, "A", usuario);
            getPacienteDao().registrarPaciente(paciente);
            req.setAttribute("mensaje", "registro de paciente exitoso");
            System.out.println("Nuevo Paciente(login=" + login + ";password=" + password + ")");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/registroUsuario.jsp").forward(req, resp);
        }
    }

    PacienteDao getPacienteDao() {
        return CitasMedicasFactory.getInstance().getPacienteDao();
    }

    UsuarioDao getUsuarioDao() {
        return CitasMedicasFactory.getInstance().getUsuarioDao();
    }
}
