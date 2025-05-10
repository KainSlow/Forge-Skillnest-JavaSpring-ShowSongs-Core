package com.jorge.mostrar_canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.mostrar_canciones.modelos.Cancion;
import com.jorge.mostrar_canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

    @Autowired
    private final RepositorioCanciones repositorioCanciones;

    public ServicioCanciones(RepositorioCanciones repositorioCanciones) {
        this.repositorioCanciones = repositorioCanciones;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return this.repositorioCanciones.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return this.repositorioCanciones.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion nuevaCancion) {
        return this.repositorioCanciones.save(nuevaCancion);
    }

    public Cancion actualizaCancion(Cancion cancion) {
        return this.repositorioCanciones.save(cancion);
    }
}
