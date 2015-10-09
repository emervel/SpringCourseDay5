/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springjpademo;

import com.curso.springjpademo.dominio.Persona;
import com.curso.springjpademo.especificacion.Servicio;
import java.util.HashMap;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
        System.out.println("Contexto cargado");
        Servicio<Persona> servicioPersona = ctx.getBean(Servicio.class);
        Persona p = servicioPersona.guardar(new Persona("persona" + System.currentTimeMillis()));
        System.out.println(servicioPersona.getLista("select p from Persona p", new HashMap<>()));
        servicioPersona.getPersona(p);
        System.out.println(p);
    }
}
