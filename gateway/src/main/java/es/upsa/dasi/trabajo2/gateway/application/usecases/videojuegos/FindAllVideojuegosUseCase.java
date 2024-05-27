package es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface FindAllVideojuegosUseCase {
    List<Videojuego> execute() throws AppException;
}
