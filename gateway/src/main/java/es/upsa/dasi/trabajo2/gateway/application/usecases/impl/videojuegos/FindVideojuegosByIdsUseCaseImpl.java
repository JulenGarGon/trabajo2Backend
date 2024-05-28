package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.videojuegos;


import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos.FindVideojuegosByIdsUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.List;

@ApplicationScoped
public class FindVideojuegosByIdsUseCaseImpl implements FindVideojuegosByIdsUseCase {

    @Inject
    Repository repository;
    @Override
    public List<Videojuego> execute(Collection<Integer> ids) throws AppException {
        return repository.findVideojuegosByIds(ids);
    }
}
