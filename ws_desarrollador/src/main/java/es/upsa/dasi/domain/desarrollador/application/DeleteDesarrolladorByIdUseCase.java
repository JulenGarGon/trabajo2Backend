package es.upsa.dasi.domain.desarrollador.application;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface DeleteDesarrolladorByIdUseCase {
    void execute(int id) throws AppException;
}
