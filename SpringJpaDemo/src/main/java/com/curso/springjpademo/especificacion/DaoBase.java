/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springjpademo.especificacion;

import com.curso.springjpademo.dominio.Entidad;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 * @param <T>
 */
@Repository
public class DaoBase<T> {

    @PersistenceContext
    private EntityManager em;   
   
    public T insertar(T objeto) {
        em.persist(objeto);
        return objeto;
    }

    public T actualizar(T objeto) {
        return em.merge(objeto);
    }

    public void borrar(T objeto) {
        em.remove(objeto);
    }

    public T buscar(Entidad objeto) {
        return (T) em.find(objeto.getClass(),objeto.getId());
    }

    public List<T> consulta(String texto, Map<String, String> parametros) {
        Query q = em.createQuery(texto);
        parametros.keySet().stream().forEach((clave) -> {
            q.setParameter(clave, parametros.get(clave));
        });
        return q.getResultList();
    }

    public List<T> consulta(String texto, Map<String, String> parametros, Integer desde, Integer cuantos) {
        Query q = em.createQuery(texto);
        parametros.keySet().stream().forEach((clave) -> {
            q.setParameter(clave, parametros.get(clave));
        });
        q.setFirstResult(desde);
        q.setMaxResults(cuantos);
        return q.getResultList();
    }
}
