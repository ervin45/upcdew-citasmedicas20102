/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dew.citasmedicas.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import pe.edu.upc.dew.citasmedicas.model.*;

/**
 *
 * @author Juan Carlos
 */
public class DataUtils {

    public static final int ROL_PACIENTE = 1;
    public static final int ROL_MEDICO = 2;
    public static final int ROL_EMPLEADO = 3;

    private List<Rol> listaRol = new ArrayList<Rol>();
    private List<Especialidad> listaEspecialidad = new ArrayList<Especialidad>();
    private List<Usuario> listaUsuario = new ArrayList<Usuario>();
    private List<Paciente> listaPaciente = new ArrayList<Paciente>();
    private List<Medico> listaMedico = new ArrayList<Medico>();
    private List<Empleado> listaEmpleado = new ArrayList<Empleado>();
    private List<HorarioAtencion> listaHorario = new ArrayList<HorarioAtencion>();
    private List<ConsultaMedica> listaConsultaMedica = new ArrayList<ConsultaMedica>();

    public void cargar() {
        //Cargar Roles
        listaRol.add(new Rol(ROL_PACIENTE, "Paciente"));
        listaRol.add(new Rol(ROL_MEDICO, "Medico"));
        listaRol.add(new Rol(ROL_EMPLEADO, "Empleado"));
        //Cargar Especialidades
        listaEspecialidad.add(new Especialidad(1, "Medicina General", "A"));
        listaEspecialidad.add(new Especialidad(2, "Traumatologia", "A"));
        //cargar Usuarios
        listaUsuario.add(new Usuario("aperez","aperez","A",listaRol.get(ROL_EMPLEADO - 1)));
        listaUsuario.add(new Usuario("klucero","klucero","A",listaRol.get(ROL_MEDICO - 1)));
        //Cargar Empleados
        listaEmpleado.add(new Empleado(1, "Ana", "Perez", "Perez", "F", "A", "01/01/1980", listaUsuario.get(0), "S"));
        //Cargar Medicos
        listaMedico.add(new Medico(1, "Konrad", "Lucero", "Bravo", "M", "A", "01/01/1970", listaUsuario.get(1), listaEspecialidad.get(0), "CAYETANO", "MEDICO GENERAL" ));
        listaMedico.add(new Medico(1, "Juan", "Carlos", "Flores", "M", "A", "01/01/1970", listaUsuario.get(1), listaEspecialidad.get(0), "CAYETANO", "MEDICO GENERAL" ));
        listaMedico.add(new Medico(1, "Jordan", "Vicaña", "Albur", "M", "A", "01/01/1970", listaUsuario.get(1), listaEspecialidad.get(0), "CAYETANO", "MEDICO GENERAL" ));
        //Cargar Horarios de Atencion
        listaHorario.add(new HorarioAtencion(1, "10:00", "11:00", listaMedico.get(0)));
        listaHorario.add(new HorarioAtencion(2, "11:00", "12:00", listaMedico.get(0)));
        listaHorario.add(new HorarioAtencion(3, "12:00", "13:00", listaMedico.get(0)));
        listaHorario.add(new HorarioAtencion(4, "15:00", "16:00", listaMedico.get(0)));
    }

    public List<Empleado> getListaEmpleado() {
        return listaEmpleado;
    }

    public List<Especialidad> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public List<HorarioAtencion> getListaHorario() {
        return listaHorario;
    }

    public List<Medico> getListaMedico() {
        return listaMedico;
    }

    public List<Paciente> getListaPaciente() {
        return listaPaciente;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public List<ConsultaMedica> getListaConsultaMedica() {
        return listaConsultaMedica;
    }

    

    
}
