package com.jorge.mostrar_canciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.mostrar_canciones.modelos.Artista;
import com.jorge.mostrar_canciones.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private final RepositorioArtistas repositorioArtistas;

    public ServicioArtistas(RepositorioArtistas repositorioArtistas) {
        this.repositorioArtistas = repositorioArtistas;
    }

    public List<Artista> obtenerTodosLosArtistas() {
        return this.repositorioArtistas.obtenerTodosLosArtistas();
    }

    public Artista obtenerArtistaPorId(Long id) {
        return this.repositorioArtistas.obtenerArtistaPorId(id);
    }

    public Artista agregarArtista(Artista artista) {

        this.repositorioArtistas.agregarArtista(artista.getId(), artista.getNombre(), artista.getApellido(),
                artista.getBiografia());

        return this.repositorioArtistas.obtenerArtistaPorId(artista.getId());
    }

    public void eliminaArtista(Long id) {
        this.repositorioArtistas.deleteById(id);
    }
}
