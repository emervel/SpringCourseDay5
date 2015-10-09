/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Estas clases son persistente dado que es una Entity. Al ser persistente necesita
 * una clave primaria (por eso usa @id) y el id es autogenerado (@GeneratedValue)
 * @author usuario
 */
@Entity
public class Aficion implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    //Esto dice que 
    @ManyToOne
    private Persona persona;

    public Aficion() {
    }

    public Aficion(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of persona
     *
     * @return the value of persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Set the value of persona
     *
     * @param persona new value of persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aficion{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
