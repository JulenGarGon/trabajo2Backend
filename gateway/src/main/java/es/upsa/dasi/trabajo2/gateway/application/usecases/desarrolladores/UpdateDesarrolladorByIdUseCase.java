package es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface UpdateDesarrolladorByIdUseCase {
    public Desarrollador execute(Desarrollador desarrollador) throws AppException;
}
