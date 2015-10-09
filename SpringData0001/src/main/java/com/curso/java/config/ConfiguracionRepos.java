/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author jose maria
 */
@Configuration
@EnableJpaRepositories("com.curso.java.repos") //Activa los repositorios (DAO) que estamos usando
public class ConfiguracionRepos {

}
