package com.jorge.mostrar_canciones.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.jorge.mostrar_canciones.modelos.Artista;

import jakarta.transaction.Transactional;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM artistas")
    List<Artista> obtenerTodosLosArtistas();

    @Query(nativeQuery = true, value = "SELECT * FROM artistas WHERE id = ?1")
    Artista obtenerArtistaPorId(Long id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO artistas (id, nombre, apellido, biografia) VALUE (?1, ?2, ?3, ?4)")
    void agregarArtista(Long id, String nombre, String apellido, String biografia);
}
