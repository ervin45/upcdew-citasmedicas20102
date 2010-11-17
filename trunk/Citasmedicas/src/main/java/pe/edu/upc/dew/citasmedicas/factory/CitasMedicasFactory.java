package pe.edu.upc.dew.citasmedicas.factory;

/*
 * BillingFactory.java
 * 
 * Created on 23/11/2007, 11:40:43 AM
 *  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dew.citasmedicas.dao.ConsultaMedicaDao;
import pe.edu.upc.dew.citasmedicas.dao.EmpleadoDao;
import pe.edu.upc.dew.citasmedicas.dao.EspecialidadDao;
import pe.edu.upc.dew.citasmedicas.dao.MedicoDao;
import pe.edu.upc.dew.citasmedicas.dao.PacienteDao;
import pe.edu.upc.dew.citasmedicas.dao.UsuarioDao;

/**
 *
 * @author 
 */
public class CitasMedicasFactory {

    private CitasMedicasFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
        factory = (BeanFactory) context;
    }
    private static CitasMedicasFactory singleton = null;
    private BeanFactory factory = null;

    public static CitasMedicasFactory getInstance() {

        if (singleton == null) {
            singleton = new CitasMedicasFactory();
        }
        return singleton;
    }

    public ConsultaMedicaDao getConsultaMedicaDao() {
        return (ConsultaMedicaDao) factory.getBean("consultaMedicaDao");
    }

    public PacienteDao getPacienteDao() {
        return (PacienteDao) factory.getBean("pacienteDao");
    }

    public UsuarioDao getUsuarioDao() {
        return (UsuarioDao) factory.getBean("usuarioDao");
    }

    public MedicoDao getMedicoDao() {
        return (MedicoDao) factory.getBean("medicoDao");
    }

    public EmpleadoDao getEmpleadoDao() {
        return (EmpleadoDao) factory.getBean("empleadoDao");
    }

    public EspecialidadDao getEspecialidadDao() {
        return (EspecialidadDao) factory.getBean("especialidadDao");
    }
}
