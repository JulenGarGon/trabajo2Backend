package es.upsa.dasi.domain.videojuego.application.impl;

import es.upsa.dasi.domain.videojuego.application.FindVideojuegosByIdDesarrolladorUseCase;
import es.upsa.dasi.domain.videojuego.domain.Repository;
import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class FindVideojuegosByIdDesarrolladorUseCaseImpl implements FindVideojuegosByIdDesarrolladorUseCase {

    @Inject
    Repository repository;

    @Override
    public List<Videojuego> execute(int id) throws AppException {
        return repository.findVideojuegosByIdDesarrollador(id);
    }
}
