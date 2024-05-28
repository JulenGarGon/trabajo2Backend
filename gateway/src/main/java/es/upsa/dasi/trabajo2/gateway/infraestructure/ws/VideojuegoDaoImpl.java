package es.upsa.dasi.trabajo2.gateway.infraestructure.ws;

import es.upsa.dasi.trabajo2.domain.entities.Videojuego;
import es.upsa.dasi.trabajo2.domain.exceptions.AppException;
import es.upsa.dasi.trabajo2.domain.exceptions.EntityNotFoundException;
import es.upsa.dasi.trabajo2.gateway.infraestructure.ws.utils.ResourceUris;
import es.upsa.dasi.trabajo2.gateway.adapters.output.daos.VideojuegoDao;
import es.upsa.dasi.trabajo2.gateway.application.dtos.ErrorDto;
import es.upsa.dasi.trabajo2.gateway.application.dtos.VideojuegoDto;
import es.upsa.dasi.trabajo2.gateway.application.mappers.Mappers;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class VideojuegoDaoImpl implements VideojuegoDao {

    @Inject
    Mappers mappers;


    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego")
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo())
            {
                //Se hace la petición y se comprueba si ha devuelto OK
                case Response.Status.OK:
                    List<Videojuego> data = response.readEntity( new GenericType<List<Videojuego>>() {});
                    return data;
                //Se ha devuelto un error 500
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public List<Videojuego> findVideojuegosByIds(Collection<Integer> ids) throws AppException {

        try (Client client = ClientBuilder.newClient()){
            Collection<String> strings = ids.stream().map(String::valueOf).collect(Collectors.toList());
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego")
                    .queryParam("ids", strings.stream().collect(Collectors.joining(",")))
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    List<Videojuego> data = response.readEntity(new GenericType<List<Videojuego>>(){});
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        try (Client client = ClientBuilder.newClient()){

            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuegos/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    List<Videojuego> data = response.readEntity( new GenericType<List<Videojuego>>(){});
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public Optional findVideojuegoById(int id) throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    Videojuego data = response.readEntity(Videojuego.class);
                    return Optional.of(data);
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            switch ( response.getStatusInfo()){
                case Response.Status.NO_CONTENT: return;

                case Response.Status.NOT_FOUND:
                    ErrorDto errorNotFound = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException(errorNotFound.getMessage());

                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException( error.getMessage() );
            }
        }
    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {

        VideojuegoDto videojuegoDto = mappers.mapToVideojuegoDto.apply(videojuego);

        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(videojuegoDto, MediaType.APPLICATION_JSON));

            switch (response.getStatusInfo()) {
                case Response.Status.CREATED:
                    Videojuego data = response.readEntity(Videojuego.class);
                    String location = response.getHeaderString(HttpHeaders.LOCATION);
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public Videojuego updateVideojuego(Videojuego videojuego) throws AppException {
        VideojuegoDto videojuegoDto = mappers.mapToVideojuegoDto.apply(videojuego);
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego/{id}")
                    .resolveTemplate("id", videojuego.id())
                    .request(MediaType.APPLICATION_JSON)
                    .put(Entity.json(videojuegoDto));

            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    Videojuego data = response.readEntity(Videojuego.class);
                    return data;

                case Response.Status.NOT_FOUND:
                    ErrorDto errorNotFound = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException(errorNotFound.getMessage());

                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }
}
