package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Optional;

public interface FindVideojuegoByIdUseCase {

    public Optional<Videojuego> execute (int id) throws AppException;
}
