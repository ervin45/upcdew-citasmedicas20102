package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dew.citasmedicas.dao.ConsultaMedicaDao;
import pe.edu.upc.dew.citasmedicas.factory.CitasMedicasFactory;
import pe.edu.upc.dew.citasmedicas.model.ConsultaMedica;
import pe.edu.upc.dew.citasmedicas.model.Medico;
import pe.edu.upc.dew.citasmedicas.model.Paciente;

public class ConsultaCitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodo = req.getParameter("metodo");
        if (metodo == null) {
            Object persona = req.getSession().getAttribute("persona");
            if (persona instanceof Paciente) {
                System.out.println("Paciente:id=" + ((Paciente) persona).getIdPersona() + ";login=" + ((Paciente) persona).getUsuario().getLogin() );
                req.setAttribute("citas", getConsultaMedicaDao().obtenerCitas(((Paciente) persona).getIdPersona()));
            } else if (persona instanceof Medico) {
                System.out.println("Medico:id=" + ((Medico) persona).getIdPersona() + ";login=" + ((Medico) persona).getUsuario().getLogin() );
                req.setAttribute("citas", getConsultaMedicaDao().obtenerCitasDeMedico(((Medico) persona).getIdPersona()));
            } else {
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
            }
            req.getRequestDispatcher("/citaConsultar.jsp").forward(req, resp);
        } else if (metodo.equals("diagnostico")) {
            String strCita = req.getParameter("cita");
            ConsultaMedica cita = getConsultaMedicaDao().obtenerCita(Integer.parseInt(strCita));
            req.setAttribute("cita", cita);
            req.getRequestDispatcher("/citaDiagnostico.jsp").forward(req, resp);
        } else if (metodo.equals("registrar")) {
            String strCita = req.getParameter("cita");
            String diagnostico = req.getParameter("diagnostico");
            ConsultaMedica cita = getConsultaMedicaDao().obtenerCita(Integer.parseInt(strCita));
            cita.setDiagnostico(diagnostico);
            System.out.println("Se registro diagnostico:cita=" + cita.getIdConsulta());
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else if (metodo.equals("ver")) {
            String strCita = req.getParameter("cita");
            ConsultaMedica cita = getConsultaMedicaDao().obtenerCita(Integer.parseInt(strCita));
            req.setAttribute("cita", cita);
            req.getRequestDispatcher("/citaDiagnostico.jsp").forward(req, resp);
        }
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    ConsultaMedicaDao getConsultaMedicaDao() {
        return CitasMedicasFactory.getInstance().getConsultaMedicaDao();
    }
}
