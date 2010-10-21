package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dew.citasmedicas.dao.CitaDaoJdbc;

import pe.edu.upc.dew.citasmedicas.model.Usuario;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;

//Programado por Juan Carlos

public class CitaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String fecha = req.getParameter("txtFechaIni");
        int errorx = -99;
        CitaDaoJdbc citaDao = new CitaDaoJdbc();
        citaDao.InsertConsultaMedicaPorFecha(fecha);
        
        req.getRequestDispatcher("/cita.jsp").forward(req, resp) ;
    }



}
