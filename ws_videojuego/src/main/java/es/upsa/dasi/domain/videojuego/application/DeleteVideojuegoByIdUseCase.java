package es.upsa.dasi.domain.videojuego.application;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteVideojuegoByIdUseCase {
    void execute(int id) throws AppException;
}
