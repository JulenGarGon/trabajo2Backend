package es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteVideojuegoByIdUseCase {

    void execute(int id) throws AppException;
}
