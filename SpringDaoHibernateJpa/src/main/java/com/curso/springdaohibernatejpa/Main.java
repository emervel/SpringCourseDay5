/*
 * Main.java
 *
 * Created on 20 de junio de 2007, 13:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaohibernatejpa;

import com.curso.springdaohibernatejpa.entidad.Empleado;
import com.curso.springdaohibernatejpa.entidad.ParteActividad;
import java.util.List;
import java.util.Random;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.curso.springdaohibernatejpa.servicio.ServicioEmpleado;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {

    private static final String APPLICATIONCONTEXT = "applicationContext.xml";

    private ApplicationContext ctx;

    /**
     * Creates a new instance of Main
     */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.ejecutarSpringHibernateJpa();
        m.ejecutarSpringHibernateJpaRelaciones();
    }

    private void init() {
        ctx = new ClassPathXmlApplicationContext(APPLICATIONCONTEXT);
        System.out.println("Contexto cargado");
    }

    private void ejecutarSpringHibernateJpa() {
        ServicioEmpleado servicio = ctx.getBean(ServicioEmpleado.class);
        Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(i -> new Empleado("Nombre" + i, "xyz@abc.com"))
                .forEach(empleado -> servicio.insertarEmpleado(empleado));
        List<Empleado> empleados = servicio.getEmpleados();
        System.out.printf("se han encontrado %d empleados\n", empleados.size());
        empleados.stream().forEach((empleado) -> {
            System.out.printf("El nombre del empleado es %s y su clave es %d\n", empleado.getNombre(), empleado.getId());
        });
    }

    private void ejecutarSpringHibernateJpaRelaciones() {
        Random r = new Random();
        Empleado empleado = new Empleado("Empleado con actividades" + System.currentTimeMillis(), "abc@xyz.com");
        ParteActividad parte = new ParteActividad(r.nextDouble(), "Actividad" + System.currentTimeMillis());
        ServicioEmpleado servicio = ctx.getBean(ServicioEmpleado.class);
        servicio.asignarParteActividad(empleado, parte);
        /*
         List<ParteActividad> actividades = servicio.getActividades(empleado);
         *      Esta línea provoca una LazyInitializationException
         */
        List<ParteActividad> actividades = servicio.getActividadesSinError(empleado);
        System.out.printf("se han encontrado %d partes de actividad \n", actividades.size());
        actividades.stream().forEach((elem) -> {
            System.out.printf("El nombre de la actividad es %s y re realizó en %f horas\n", elem.getNombre(), elem.getHoras());
        });
    }
}
