package es.upsa.dasi.trabajo2.domain.entities;

import lombok.Singular;

import java.util.List;

public class VideojuegosDesarrolladorFull {

    private Desarrollador desarrollador;
   @Singular(value = "videojuego")
   private List<Videojuego> videojuegos;
}
