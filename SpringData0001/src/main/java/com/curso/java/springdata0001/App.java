package com.curso.java.springdata0001;

import com.curso.java.config.ConfiguracionBd;
import com.curso.java.config.ConfiguracionCache;
import com.curso.java.config.ConfiguracionRepos;
import com.curso.java.modelo.Aficion;
import com.curso.java.modelo.Persona;
import com.curso.java.servicios.ServicioPersona;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static java.lang.System.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfiguracionBd.class, ConfiguracionCache.class, ConfiguracionRepos.class);
        ServicioPersona servicioPersona = ctx.getBean(ServicioPersona.class);
        Persona p = new Persona("abc", false);
        Aficion a = new Aficion("xyz");
        p.getAficiones().add(a);
        a.setPersona(p);
        servicioPersona.nuevaPersona(p);
        List<Persona> lista = servicioPersona.todos();
        lista.forEach(out::println);
        lista = servicioPersona.todos();
        System.out.println("Desde el caché");
        lista.forEach(out::println);
        p = servicioPersona.buscarPorNombre("abc");
        assert p.getNombre().equals("abc") : "El nombre de la persona no coincide";
        System.out.println(servicioPersona.cambiarNombre("xyz", "abc"));
        p = servicioPersona.buscarPorNombre("xyz");
        assert p.getNombre().equals("xyz") : "El nombre de la persona no coincide";
        System.out.println("Buscando por aficiones...");
        lista = servicioPersona.buscarPorAficiones(a);
        lista.forEach(out::println);
        System.out.println("Fin");
    }
}
