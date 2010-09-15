package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import pe.edu.upc.dew.citasmedicas.model.Empleado;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Persona;
import pe.edu.upc.dew.citasmedicas.model.Rol;
import pe.edu.upc.dew.citasmedicas.model.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import pe.edu.upc.dew.citasmedicas.dao.ConsultaMedicaDaoJdbc;

public class ConsultaPacienteServlet extends HttpServlet {
   
        
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        Usuario usuario = new Usuario();
        Date fecha = new Date();
        List<ConsultaMedica> loConsultaMedica = null;
        ConsultaMedica consultaMedica = null;
        String jSonData = "";
        
        HttpSession session = req.getSession();
        
        String strfechaInicio = req.getParameter("datePickerInicio");
        String strfechaFin = req.getParameter("datePickerFin");
        ConsultaMedicaDaoJdbc consultaMedicaDaoJdbc = new ConsultaMedicaDaoJdbc();
        loConsultaMedica = consultaMedicaDaoJdbc.getConsultaMedicaPorFecha(strfechaInicio, strfechaFin);
        //jSonData = consultaMedicaDaoJdbc.getConsultaMedicaPorFecha(strfechaInicio, strfechaFin);
        //req.setAttribute("consultaMedica", jSonData);
        
        if (loConsultaMedica != null)  {
            
            Integer cant = loConsultaMedica.size();            
            Iterator iter = loConsultaMedica.iterator();
            
            /*
            for (int i=0; i< loConsultaMedica.size(); i++){
                consultaMedica = new ConsultaMedica();                

            }
            */
            

            jSonData = "[";
            //jSonData = loConsultaMedica.toString();
            
            while (iter.hasNext()){              
              consultaMedica = new ConsultaMedica();
              consultaMedica = (ConsultaMedica)iter.next();
              jSonData = jSonData + "{\"id\":\"" + consultaMedica.getFechaRegistro() + "\",";
              jSonData = jSonData + "\"start\":\"" + consultaMedica.getFechaRegistro() + "\",";
              jSonData = jSonData + "\"end\":\"" + consultaMedica.getFechaRegistro() + "\",";
              jSonData = jSonData + "\"title\":\"" + consultaMedica.getFechaRegistro() + "\"},";
            }
            jSonData =
            jSonData = jSonData + "}]";
            
            req.setAttribute("consultaMedica", jSonData);
        }
        else{
            System.out.println("No existen consultas medicas registradas en el rango de fechas seleccionadas");
        }
        req.getRequestDispatcher("/consultaPaciente.jsp").forward(req, resp) ;
    }  
}
