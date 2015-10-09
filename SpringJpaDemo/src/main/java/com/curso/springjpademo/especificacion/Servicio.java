/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.springjpademo.especificacion;

import com.curso.springjpademo.dominio.Entidad;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrador
 * @param <T>
 */
@Service
@Transactional
public class Servicio<T> {

    @Autowired
    private DaoBase<T> dao;

    public T guardar(T objeto) {
        return dao.insertar(objeto);
    }

    @Transactional(readOnly = true)
    public List<T> getLista(String texto, Map<String, String> parametros, Integer desde, Integer cuantos) {
        return dao.consulta(texto, parametros, desde, cuantos);
    }

    @Transactional(readOnly = true)
    public List<T> getLista(String texto, Map<String, String> parametros) {
        return dao.consulta(texto, parametros);
    }

    public void eliminar(T objeto) {
        dao.borrar(objeto);
    }

    @Transactional(readOnly = true)
    public T getPersona(Entidad objeto) {
        return dao.buscar(objeto);
    }
}
