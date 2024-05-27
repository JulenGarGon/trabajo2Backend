package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.videojuegos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos.FindVideojuegosByIdUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class FindVideojuegosByIdUseCaseImpl implements FindVideojuegosByIdUseCase {
    @Inject
    Repository repository;
    @Override
    public Optional<Videojuego> execute(int id) throws AppException {
        return repository.findVideojuegoById(id);
    }
}
