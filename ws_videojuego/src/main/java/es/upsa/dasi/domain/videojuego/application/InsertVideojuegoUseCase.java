package es.upsa.dasi.domain.videojuego.application;


import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface InsertVideojuegoUseCase {
    public Videojuego execute(Videojuego videojuego) throws AppException;
}
