package es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface UpdateVideojuegosByIdUseCase {
    public Videojuego execute(Videojuego videojuego) throws AppException;
}
