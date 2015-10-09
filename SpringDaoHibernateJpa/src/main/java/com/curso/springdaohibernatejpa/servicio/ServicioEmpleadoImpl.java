/*
 * ServicioEmpleadoImpl.java
 *
 * Created on 20 de junio de 2007, 14:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.curso.springdaohibernatejpa.servicio;

import com.curso.springdaohibernatejpa.dao.EmpleadoDao;
import com.curso.springdaohibernatejpa.entidad.Empleado;
import com.curso.springdaohibernatejpa.entidad.ParteActividad;
import java.util.List;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Administrador
 */
public class ServicioEmpleadoImpl implements ServicioEmpleado{
    private EmpleadoDao empleadoDao;
   
    @Override
    public List<Empleado> getEmpleados() {
        return empleadoDao.getEmpleados();
    }
    
    @Override
    public Empleado insertarEmpleado(Empleado empleado) {
        return empleadoDao.insertarEmpleado(empleado);
    }
    
    @Override
    public void asignarParteActividad(Empleado empleado, ParteActividad parteActividad) {
        empleadoDao.asignarParteActividad(empleado,parteActividad);
    }
    
    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }
    
    @Override
    public List<ParteActividad> getActividades(Empleado empleado)  {
        return empleadoDao.getActividades(empleado);
    }

    @Override
    public List<ParteActividad> getActividadesSinError(Empleado empleado) throws DataAccessException {
        return empleadoDao.getActividadesSinError(empleado);
    }
    
}
