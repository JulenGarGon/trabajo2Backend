package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.desarrolladores;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores.InsertDesarrolladorUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertDesarrolladorUseCaseImpl implements InsertDesarrolladorUseCase {

    @Inject
    Repository repository;
    @Override
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException {
        return repository.saveDesarrollador(desarrollador);
    }
}
