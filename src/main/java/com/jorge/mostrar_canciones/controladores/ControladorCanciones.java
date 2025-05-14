package com.jorge.mostrar_canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.jorge.mostrar_canciones.modelos.Artista;
import com.jorge.mostrar_canciones.modelos.Cancion;
import com.jorge.mostrar_canciones.servicios.ServicioArtistas;
import com.jorge.mostrar_canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorCanciones {

    @Autowired
    private final ServicioArtistas servicioArtistas;

    @Autowired
    private final ServicioCanciones servicioCanciones;

    public ControladorCanciones(
            ServicioCanciones servicioCanciones,
            ServicioArtistas servicioArtistas) {
        this.servicioCanciones = servicioCanciones;
        this.servicioArtistas = servicioArtistas;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {

        List<Cancion> listaDeCanciones = servicioCanciones.obtenerTodasLasCanciones();
        model.addAttribute("canciones", listaDeCanciones);
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
    public String formularioAgregarCancion(
            @ModelAttribute("cancion") Cancion cancion,
            Model modelo) {

        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
        modelo.addAttribute("artistas", artistas);
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

        List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();

        modelo.addAttribute("artistas", artistas);
        modelo.addAttribute("cancion", cancion);
        return "editarCancion.jsp";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesaAgregarCancion(
            @Valid @ModelAttribute("cancion") Cancion cancion,
            BindingResult validaciones,
            @RequestParam("id_artista") Long idArtista) {

        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }

        cancion.setArtista(this.servicioArtistas.obtenerArtistaPorId(idArtista));
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

    @DeleteMapping("/canciones/eliminar/{id}")
    public String procesaEliminarCancion(@PathVariable("id") Long id) {
        this.servicioCanciones.eliminaCancion(id);
        return "redirect:/canciones";
    }
}
