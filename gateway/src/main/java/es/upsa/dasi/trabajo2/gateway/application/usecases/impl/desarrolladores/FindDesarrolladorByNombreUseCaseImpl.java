package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.desarrolladores;


import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores.FindDesarrolladorByNombreUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class FindDesarrolladorByNombreUseCaseImpl implements FindDesarrolladorByNombreUseCase {

    @Inject
    Repository repository;
    @Override
    public Optional<Desarrollador> execute(String nombre) throws AppException {
        return repository.findDesarrolladorByNombre(nombre);
    }
}
