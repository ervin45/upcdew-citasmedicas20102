package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import pe.edu.upc.dew.citasmedicas.dao.ConsultaMedicaDao;
import pe.edu.upc.dew.citasmedicas.dao.EspecialidadDao;
import pe.edu.upc.dew.citasmedicas.dao.PacienteDao;
import pe.edu.upc.dew.citasmedicas.factory.CitasMedicasFactory;
import pe.edu.upc.dew.citasmedicas.model.HorarioAtencion;
import pe.edu.upc.dew.citasmedicas.model.Paciente;
import pe.edu.upc.dew.citasmedicas.model.Persona;

public class RegistroCitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodo = req.getParameter("metodo");
        if (metodo == null) {
        } else if (metodo.equals("buscar")) {
            String especialidad = req.getParameter("especialidad");
            if (especialidad != null && especialidad.length() > 0) {
                req.setAttribute("horarios", getConsultaMedicaDao().cargarHorario(Integer.valueOf(especialidad.trim())));
            }
        } else if (metodo.equals("registrar")) {
            String strHorario = req.getParameter("horario");
            String strPaciente = req.getParameter("paciente");
            if (strHorario != null && strHorario.length() > 0 && strPaciente != null && strPaciente.length() > 0) {
                HorarioAtencion horario = getConsultaMedicaDao().obtenerHorario(Integer.parseInt(strHorario));
                Paciente paciente = getPacienteDao().obtenerPaciente(strPaciente);
                getConsultaMedicaDao().registrarCita(horario, paciente);
                System.out.println("Horario:" + horario.getIdHorario() + ";Paciente:" + paciente.getUsuario().getLogin());
            }
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        } else {
        }
        req.setAttribute("especialidades", getEspecialidadDao().obtenerEspecialidades());

        if (req.getSession().getAttribute("persona") == null || !((Persona) req.getSession().getAttribute("persona")).getUsuario().getRol().getNombre().equals("Paciente")) {
            req.setAttribute("pacientes", getPacienteDao().obtenerPacientes());
        }

        req.getRequestDispatcher("/citaRegistrar.jsp").forward(req, resp);
    }

    EspecialidadDao getEspecialidadDao() {
        return CitasMedicasFactory.getInstance().getEspecialidadDao();
    }

    ConsultaMedicaDao getConsultaMedicaDao() {
        return CitasMedicasFactory.getInstance().getConsultaMedicaDao();
    }

    PacienteDao getPacienteDao() {
        return CitasMedicasFactory.getInstance().getPacienteDao();
    }
}
