package es.upsa.dasi.domain.desarrollador.application;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.Optional;
public interface FindDesarrolladorByNombreUseCase {

    Optional<Desarrollador> execute(String nombre) throws AppException;
}
