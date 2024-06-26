package es.upsa.dasi.trabajo2.domain.entities;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@Builder(setterPrefix = "with")
@With
public record Videojuego(int id,
                         String nombre,
                         String genero,
                         String estreno,
                         String portada,
                         float duracion,
                         float tamanio,
                         int ventas,
                         int desarrollador,
                         float nota
                         )
{
}
