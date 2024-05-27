package es.upsa.dasi.trabajoii.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo1.domain.exceptions.AppException;

public interface DeleteDesarrolladorByIdUseCase {
    void execute(int id) throws AppException;
}
