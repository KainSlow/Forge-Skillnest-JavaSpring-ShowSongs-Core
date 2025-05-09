package com.jorge.mostrar_canciones.servicios;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorge.mostrar_canciones.modelos.Cancion;
import com.jorge.mostrar_canciones.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    
    @Autowired
    private final RepositorioCanciones repositorioCanciones;

    public ServicioCanciones(RepositorioCanciones repositorioCanciones){
        this.repositorioCanciones = repositorioCanciones;
    }

    public List<Cancion> obtenerTodasLasCanciones(){
        return this.repositorioCanciones.findAll();
    }

    public Cancion obtenerCancionPorId(Long id){
        Cancion cancion;

        try{
            cancion = this.repositorioCanciones.findById(id).get();
        }
        catch(IllegalArgumentException e){
            //cancion = new Cancion("No encontrada", "Desconocido");
            cancion = null;
        }
        catch(NoSuchElementException e){
            //cancion = new Cancion("No encontrada", "Desconocido");
            cancion = null;
        }

        return cancion;
    }
}
