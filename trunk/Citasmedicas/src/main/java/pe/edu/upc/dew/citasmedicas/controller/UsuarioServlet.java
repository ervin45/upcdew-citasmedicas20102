package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import pe.edu.upc.dew.citasmedicas.model.Empleado;
import pe.edu.upc.dew.citasmedicas.model.Usuario;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Persona;


public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Persona> mPersona;
        mPersona = new ArrayList<Persona>();
        //mPersona = (ArrayList<Persona>) session.getAttribute("mpersonas");
        //Date date=null;
        //SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
        Usuario usuario = new Usuario();
        usuario.setUsuario(req.getParameter("txtUsuario"));
        usuario.setPassword(req.getParameter("txtPassword"));
        //try {
        //    date = format.parse(req.getParameter("txtFechaNacimiento"));
        //} catch (ParseException ex) {
        //    Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        //}
        Paciente paciente = new Paciente(
                0,req.getParameter("txtNombres"),
                req.getParameter("txtApellidoPaterno"),
                req.getParameter("txtApellidoMaterno"),
                req.getParameter("btnSexo"),
                "A",
                //date,
                null,
                usuario
                );
        //usuario.setPaciente(paciente);        
        session.setAttribute("usuario", usuario);
        //       
        //mPersona = (ArrayList<Persona>) session.getAttribute("mpersonas");
        mPersona.add(paciente);
        session.setAttribute("mpersonas", mPersona);
            
        req.getRequestDispatcher("/login.jsp").forward(req, resp) ;
    }       
}
