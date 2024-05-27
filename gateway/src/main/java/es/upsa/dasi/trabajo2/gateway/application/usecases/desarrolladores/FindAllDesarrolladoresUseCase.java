package es.upsa.dasi.trabajo2.gateway.application.usecases.desarrolladores;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

import java.util.List;

public interface FindAllDesarrolladoresUseCase {
    List<Desarrollador> execute() throws AppException;
}
