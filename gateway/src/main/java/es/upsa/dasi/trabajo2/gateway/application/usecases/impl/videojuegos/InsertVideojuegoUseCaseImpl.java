package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.videojuegos;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos.InsertVideojuegoUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InsertVideojuegoUseCaseImpl implements InsertVideojuegoUseCase {
    @Inject
    Repository repository;

    @Override
    public Videojuego execute(Videojuego videojuego) throws AppException {
        return repository.save(videojuego);
    }
}
