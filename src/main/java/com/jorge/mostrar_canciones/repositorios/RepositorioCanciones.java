package com.jorge.mostrar_canciones.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jorge.mostrar_canciones.modelos.Cancion;
import org.springframework.lang.NonNull;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{
    
    @NonNull
    List<Cancion> findAll();
}
