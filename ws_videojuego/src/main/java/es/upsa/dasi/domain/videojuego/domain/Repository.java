package es.upsa.dasi.domain.videojuego.domain;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository {
    List<Videojuego> findAllVideojuegos() throws AppException;

    List<Videojuego> findVideojuegosByIds(Collection<Integer> ids) throws AppException;

    List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException;

    Optional findVideojuegoById(int id) throws AppException;

    void deleteVideojuegoById(int id) throws AppException;

    Videojuego save(Videojuego videojuego) throws AppException;
}
