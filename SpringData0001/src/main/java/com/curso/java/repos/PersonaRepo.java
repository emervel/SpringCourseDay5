/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.repos;

import com.curso.java.modelo.Aficion;
import com.curso.java.modelo.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *Al heredar de JpaRepository se generan automáticamente los DAO
 * El Long representa la clave primaria de la clase Persona
 * @author jose maria
 */
public interface PersonaRepo extends JpaRepository<Persona, Long> {

    //Spring hace transaccional todos los metodos que cumplan su nomenclatura
    
    //La nomenclatura del metodo esta predefinida, find es para bucar un objeto de una class By una propiedad
    //es lo mismo que select p from Persona p where p.nombre= ?
    //Además esta query se ejecutara y seteará los parametros en un sólo objeto de tipo Peronsa
    Persona findByNombre(String nombre);

    List<Persona> findByAficiones(List<Aficion> aficiones);
    /*Estos metodos tb permite trabajar con metodos asincronos para lo que usara futuros
    Future<Persona> findByNombre(String nombre);
    ListenableFuture<List<Persona>> findByAficiones(List<Aficion> aficiones);
    */

    @Modifying //Se informa a Spring de que este metodo puede modificar la BBDD
    @Query("update Persona p set p.nombre = ?1 where p.nombre = ?2") //Esta anotacion permite poner el texto que queramos en JPAQL
    @Transactional // Como este metodo es nuestro (xq no hemos usado nomenclatura) le tenemos que indicar que es transaccional
    Integer cambiarNombre(String nombreNuevo, String nombreAntiguo);

    @Modifying
    @Transactional
    @Query("delete from Persona p where p.activo = false")
    void borrarUsuariosInactivos();
}
