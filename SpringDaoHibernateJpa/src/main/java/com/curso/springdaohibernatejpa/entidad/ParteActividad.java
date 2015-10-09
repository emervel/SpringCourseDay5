/*
 * ParteActividad.java
 *
 * Created on 20 de junio de 2007, 13:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package com.curso.springdaohibernatejpa.entidad;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity class ParteActividad
 *
 * @author Administrador
 */
@Entity
public class ParteActividad implements Serializable {

    @ManyToOne
    private Empleado empleado;

    @Id
    @GeneratedValue
    private Long id;
    private Double horas;
    private String nombre;

    /**
     * Creates a new instance of ParteActividad
     */
    public ParteActividad() {
    }

    public ParteActividad(Double horas, String nombre) {
        this.horas = horas;
        this.nombre = nombre;
    }

    /**
     * Gets the id of this ParteActividad.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this ParteActividad to the specified value.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object. This implementation computes a
     * hash code value based on the id fields in this object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this ParteActividad. The
     * result is <code>true</code> if and only if the argument is not null and
     * is a ParteActividad object that has the same id field values as this
     * object.
     *
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParteActividad)) {
            return false;
        }
        ParteActividad other = (ParteActividad) object;
        return !(!Objects.equals(this.getId(), other.getId()) && (this.getId() == null || !this.getId().equals(other.getId())));
    }

    /**
     * Returns a string representation of the object. This implementation
     * constructs that representation based on the id fields.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "beans.entidad.ParteActividad[id=" + getId() + "]";
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Double getHoras() {
        return horas;
    }

    public void setHoras(Double horas) {
        this.horas = horas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
