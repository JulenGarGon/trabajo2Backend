package es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Optional;
public interface FindDesarrolladorByNombreUseCase {

    Optional<Desarrollador> execute(String nombre) throws AppException;
}
