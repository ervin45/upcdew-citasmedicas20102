package pe.edu.upc.dew.citasmedicas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import pe.edu.upc.dew.citasmedicas.dao.EmpleadoDao;
import pe.edu.upc.dew.citasmedicas.dao.MedicoDao;
import pe.edu.upc.dew.citasmedicas.dao.PacienteDao;
import pe.edu.upc.dew.citasmedicas.dao.UsuarioDao;
import pe.edu.upc.dew.citasmedicas.factory.CitasMedicasFactory;

import pe.edu.upc.dew.citasmedicas.model.Usuario;
import pe.edu.upc.dew.citasmedicas.util.DataUtils;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Usuario usuario = getUsuarioDao().validarUsuario(login, password);
        if (usuario == null) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else if (usuario.getEstado()== null || !usuario.getEstado().equals("A")) {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            Object persona = null;
            int idRol = usuario.getRol().getIdRol().intValue();
            if (idRol == DataUtils.ROL_PACIENTE) {
                persona = getPacienteDao().obtenerPaciente(login);
            } else if (idRol == DataUtils.ROL_MEDICO) {
                persona = getMedicoDao().obtenerMedico(login);
            } else if (idRol == DataUtils.ROL_EMPLEADO) {
                persona = getEmpleadoDao().obtenerEmpleado(login);
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("persona", persona);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        }

    }

    UsuarioDao getUsuarioDao() {
        return CitasMedicasFactory.getInstance().getUsuarioDao();
    }

    PacienteDao getPacienteDao() {
        return CitasMedicasFactory.getInstance().getPacienteDao();
    }

    MedicoDao getMedicoDao() {
        return CitasMedicasFactory.getInstance().getMedicoDao();
    }

    EmpleadoDao getEmpleadoDao() {
        return CitasMedicasFactory.getInstance().getEmpleadoDao();
    }
}
