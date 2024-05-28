package es.upsa.dasi.trabajo2.domain.entities;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.With;

import java.util.List;

@Value
@Builder(setterPrefix = "with")
@With
public class VideojuegoDesarrollador {

    private int idVideojuego;

    @Singular("videojuegoDes")
    private List<Videojuego> videojuegosDesarrollados;

}
