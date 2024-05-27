package es.upsa.dasi.trabajo2.gateway.application.usecases.impl.desarrolladores;


import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores.DeleteDesarrolladorByIdUseCase;
import es.upsa.dasi.trabajo2.gateway.domain.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteDesarrolladorByIdUseCaseImpl implements DeleteDesarrolladorByIdUseCase {

    @Inject
    Repository repository;

    @Override
    public void execute(int id) throws AppException {
        repository.deleteDesarrollador(id);
    }
}
