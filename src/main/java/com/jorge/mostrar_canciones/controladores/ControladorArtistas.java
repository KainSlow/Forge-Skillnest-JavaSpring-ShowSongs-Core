package com.jorge.mostrar_canciones.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;

import com.jorge.mostrar_canciones.modelos.Artista;
import com.jorge.mostrar_canciones.servicios.ServicioArtistas;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorArtistas {

    @Autowired
    private final ServicioArtistas servicioArtistas;

    public ControladorArtistas(ServicioArtistas servicioArtistas) {
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/artistas")
    public String desplegarArtistas(Model modelo) {

        modelo.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas.jsp";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(
            @PathVariable("idArtista") Long id,
            Model modelo) {

        Artista artista = servicioArtistas.obtenerArtistaPorId(id);
        if (artista == null) {
            return "redirect:/artistas";
        }

        modelo.addAttribute("artista", artista);
        return "detalleArtista.jsp";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(@ModelAttribute("artista") Artista artista) {
        return "agregarArtista.jsp";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(
            @Valid @ModelAttribute("artista") Artista artista,
            BindingResult validaciones) {

        if (validaciones.hasErrors()) {
            return "agregarArtista.jsp";
        }

        this.servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }

    @DeleteMapping("/artistas/eliminar/{id}")
    public String procesaEliminarArtista(@PathVariable("id") Long id) {

        this.servicioArtistas.eliminaArtista(id);
        return "redirect:/artistas";
    }

}
