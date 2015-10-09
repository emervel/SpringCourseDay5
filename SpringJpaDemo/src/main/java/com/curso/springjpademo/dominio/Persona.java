/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springjpademo.dominio;

import javax.persistence.Entity;

/**
 *
 * @author Administrador
 */
@Entity
public class Persona extends Entidad  {

    private String nombre;

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Mi nombre es " + getNombre();
    }


}
