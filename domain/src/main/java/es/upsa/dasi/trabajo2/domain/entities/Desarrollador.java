package es.upsa.dasi.trabajo2.domain.entities;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@Builder(setterPrefix = "with")
@With
public record Desarrollador (int id,
                             String nombre,
                             String fundacion,
                             String fundador,
                             int empleados,
                             String sede,
                             String sitioWeb,
                             String logo
                             )
{
}
