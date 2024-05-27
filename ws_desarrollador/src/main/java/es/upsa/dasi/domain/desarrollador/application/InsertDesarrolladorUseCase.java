package es.upsa.dasi.domain.desarrollador.application;

import es.upsa.dasi.trabajo2.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;

public interface InsertDesarrolladorUseCase {
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException;
}
