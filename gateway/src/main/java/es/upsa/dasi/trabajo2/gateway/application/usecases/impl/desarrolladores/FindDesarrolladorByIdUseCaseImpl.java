package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.desarrolladores;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class FindDesarrolladorByIdUseCaseImpl implements FindDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public Optional<Desarrollador> execute(int id) throws AppException {
        return repository.findDesarrolladorById(id);
    }
}
