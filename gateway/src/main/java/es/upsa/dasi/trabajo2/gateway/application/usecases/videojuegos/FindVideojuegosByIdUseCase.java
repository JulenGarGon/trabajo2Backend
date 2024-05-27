package es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Optional;

public interface FindVideojuegosByIdUseCase {
    public Optional<Videojuego> execute (int id) throws AppException;
}
