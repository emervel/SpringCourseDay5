/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import beans.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Chema
 */
@Controller
@RequestMapping("/tercera.html")
public class OtroControlador25 {

    @Autowired(required = true)
    private Persona persona;

    @ModelAttribute("persona")
    public Persona getPersona() {
        return persona;
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public void manejadorGet(){
        
    }
}
