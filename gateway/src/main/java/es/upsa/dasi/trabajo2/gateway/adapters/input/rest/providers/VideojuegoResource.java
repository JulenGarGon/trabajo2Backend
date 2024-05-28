package es.upsa.dasi.trabajo2.gateway.adapters.input.rest.providers;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.gateway.application.dtos.VideojuegoDto;
import es.upsa.dasi.trabajo2.gateway.application.mappers.Mappers;
import es.upsa.dasi.trabajo2.gateway.application.usecases.videojuegos.*;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Path("/videojuego")
public class VideojuegoResource {

    @Inject
    Mappers mappers;

    @Context
    UriInfo uriInfo;

    @Inject
    FindAllVideojuegosUseCase findAllVideojuegosUseCase;

    @Inject
    FindVideojuegosByIdUseCase findVideojuegosByIdUseCase;

    @Inject
    DeleteVideojuegoByIdUseCase deleteVideojuegoByIdUseCase;

    @Inject
    InsertVideojuegoUseCase insertVideojuegoUseCase;

    @Inject
    UpdateVideojuegosByIdUseCase updateVideojuegosByIdUseCase;

    @Inject
    FindVideojuegosByIdsUseCase findVideojuegosByIdsUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllVideojuegos(@DefaultValue("") @QueryParam("ids") Collection<Integer> ids) throws AppException{

        List<Videojuego> videojuegos = ids.isEmpty()? findAllVideojuegosUseCase.execute() : findVideojuegosByIdsUseCase.execute(ids);
        return  Response.ok()
                .entity(videojuegos)
                .build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVideojuegoById(@PathParam("id")int id) throws AppException{
        Optional<Videojuego> optional = findVideojuegosByIdUseCase.execute(id);
        if (optional.isEmpty()){
            return Response.status( Response.Status.NOT_FOUND)
                           .build();
        }
        return Response.ok()
                        .entity(optional.get())
                        .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteVideojuegoById(@PathParam("id")int id) throws AppException{
        deleteVideojuegoByIdUseCase.execute(id);
        return Response.noContent().build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVideojuego(VideojuegoDto videojuegoDto) throws AppException{
        Videojuego videojuego = mappers.mapToVideojuego.apply(videojuegoDto);

        Videojuego newVideojuego = insertVideojuegoUseCase.execute(videojuego);
        URI newVideojuegoURI = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", newVideojuego.id())
                .build();

        return Response.created(newVideojuegoURI)
                .entity(newVideojuego)
                .build();
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateVideojuego(@PathParam("id")int id, VideojuegoDto videojuegoDto) throws AppException{
        Videojuego videojuego = mappers.toVideojuego.apply(id, videojuegoDto);
        Videojuego updatedVideojuego = updateVideojuegosByIdUseCase.execute(videojuego);

        return Response.ok()
                        .entity(updatedVideojuego)
                        .build();
    }
}
