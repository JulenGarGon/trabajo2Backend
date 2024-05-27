package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.videojuegos;

import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos.DeleteVideojuegoByIdUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteVideojuegoByIdUseCaseImpl implements DeleteVideojuegoByIdUseCase {
    @Inject
    Repository repository;

    @Override
    public void execute(int id) throws AppException {
        repository.deleteVideojuegoById(id);
    }
}
