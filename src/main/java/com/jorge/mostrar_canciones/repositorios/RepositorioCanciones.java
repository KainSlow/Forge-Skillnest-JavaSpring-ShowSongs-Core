package com.jorge.mostrar_canciones.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jorge.mostrar_canciones.modelos.Cancion;

import jakarta.transaction.Transactional;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {

    @Query("SELECT c FROM Cancion c")
    List<Cancion> obtenerTodasLasCanciones();

    @Query("SELECT c FROM Cancion c WHERE c.id = ?1")
    Cancion obtenerCancionPorId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cancion c WHERE c.id = ?1")
    void eliminaCancion(Long id);
}
