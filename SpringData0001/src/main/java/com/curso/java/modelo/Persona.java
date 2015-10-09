/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jose maria
 */
@Entity
public class Persona implements Serializable {

    //identificador
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    private Boolean activo = false;

    /*Esto indica la relacion entre la clase persona y las aficiones (One to May)*/
    @OneToMany(mappedBy = "persona", 
            cascade = CascadeType.ALL, 
            fetch = FetchType.EAGER, //Para traerte todas las aficiones cuando recuperas una persona (No es recomendable) 
            orphanRemoval = true)//Esto es para que se elimine la aficion si se elimina la persona de la BBDD
    private List<Aficion> aficiones;

    /**
     * Get the value of aficiones
     *
     * @return the value of aficiones
     */
    public List<Aficion> getAficiones() {
        if (aficiones == null) {
            aficiones = new ArrayList<>();
        }
        return aficiones;
    }

    /**
     * Set the value of aficiones
     *
     * @param aficiones new value of aficiones
     */
    public void setAficiones(List<Aficion> aficiones) {
        this.aficiones = aficiones;
    }

    /**
     * Get the value of activo
     *
     * @return the value of activo
     */
    public Boolean isActivo() {
        return activo;
    }

    /**
     * Set the value of activo
     *
     * @param activo new value of activo
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Persona() {
    }

    public Persona(String nombre, Boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", activo=" + activo + ", aficiones=" + aficiones + '}';
    }

}
