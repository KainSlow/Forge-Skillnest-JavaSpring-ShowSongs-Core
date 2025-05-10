package com.jorge.mostrar_canciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jorge.mostrar_canciones.modelos.Cancion;
import com.jorge.mostrar_canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ControladorCanciones {

    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String detalleCancion(@PathVariable(name = "idCancion") Long idCancion, Model model) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);

        if (cancion == null)
            return "redirect:/canciones";

        model.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion.jsp";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion.jsp";
    }

    @GetMapping("/canciones/formulario/editar/{id}")
    public String formularioEditarCancion(
            @PathVariable("id") Long id,
            @ModelAttribute("cancion") Cancion cancionModelo,
            Model modelo) {

        Cancion cancion = servicioCanciones.obtenerCancionPorId(id);
        if (cancion == null) {
            return "redirect:/canciones";
        }
        modelo.addAttribute("cancion", cancion);
        return "editarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesaAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }

        this.servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    @PutMapping("/canciones/procesa/editar/{id}")
    public String procesarEditarCancion(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute Cancion cancion,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "editarCancion.jsp";
        }
        cancion.setId(id);
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

}
