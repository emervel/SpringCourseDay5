/*
 * EmpleadoDaoImpl.java
 *
 * Created on 20 de junio de 2007, 13:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaohibernatejpa.dao;

import com.curso.springdaohibernatejpa.entidad.Empleado;
import com.curso.springdaohibernatejpa.entidad.ParteActividad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {

    @PersistenceContext
    private EntityManager em;

    /** Creates a new instance of EmpleadoDaoImpl */
    public EmpleadoDaoImpl() {
    }

    @Override
    public List<Empleado> getEmpleados() {
        Query query = em.createQuery("select e from Empleado as e");
        return query.getResultList();
    }

    @Override
    public Empleado insertarEmpleado(Empleado empleado) {
        em.persist(empleado);
        return empleado;
    }

    @Override
    public void asignarParteActividad(Empleado empleado, ParteActividad parteActividad) {
        empleado.getActividades().add(parteActividad);
        parteActividad.setEmpleado(empleado);
        em.persist(empleado);
    }

    @Override
    public List<ParteActividad> getActividades(Empleado empleado) {
        Empleado e = em.find(Empleado.class, empleado.getId());
        return e.getActividades();
    }

    @Override
    public List<ParteActividad> getActividadesSinError(Empleado empleado) {
        List<ParteActividad> p = new ArrayList<>();
        p.addAll(em.find(Empleado.class, empleado.getId()).getActividades());
        return p;
    }
}
