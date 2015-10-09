/*
 * EmpleadoDao.java
 *
 * Created on 20 de junio de 2007, 13:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.curso.springdaohibernatejpa.dao;

import com.curso.springdaohibernatejpa.entidad.Empleado;
import com.curso.springdaohibernatejpa.entidad.ParteActividad;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface EmpleadoDao {
    List<Empleado> getEmpleados();
    Empleado insertarEmpleado(Empleado empleado);
    void asignarParteActividad(Empleado empleado, ParteActividad parteActividad);    
    List<ParteActividad> getActividades(Empleado empleado);
    List<ParteActividad> getActividadesSinError(Empleado empleado);
}
