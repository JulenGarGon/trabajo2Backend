package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Collection;
import java.util.List;

public interface FindVideojuegosByIdsUseCase {

    List<Videojuego> execute(Collection<Integer> ids) throws AppException;
}
