package com.jorge.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.jorge.mostrar_canciones.servicios.ServicioCanciones;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorCanciones {

    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones){
        this.servicioCanciones = servicioCanciones;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String getMethodName(@PathVariable(name = "idCancion") Long idCancion, Model model) {
        model.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion.jsp";
    }
    
    
}
