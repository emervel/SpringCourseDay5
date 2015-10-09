/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Chema
 */
@Controller
public class Controlador25 {

    @ModelAttribute("hora")
    public Date getHora(){
        return new Date();
    }
    @RequestMapping("/primera.html")
    public void primeraHandler() {
    }

    @RequestMapping("/segunda.html")
    public ModelMap segundaHandler(@RequestParam("id") String strId) {
        ModelMap mav = new ModelMap();
        mav.addAttribute("parametro", strId);
        return mav;
    }
}
