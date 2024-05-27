package es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteDesarrolladorByIdUseCase {
    void execute(int id) throws AppException;
}
