package es.upsa.dasi.trabajo2.gateway.adapters.input.rest.providers.paramconverters;

import jakarta.ws.rs.ext.ParamConverter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionParamConverter implements ParamConverter<Collection<Integer>> {

    private String delimiter;

    public CollectionParamConverter(String delimiter) {
        this.delimiter = delimiter;
    }

    @Override
    public Collection<Integer> fromString(String data) {
        if ("".equals(data)) return List.of();

        String[] tokens = data.split(delimiter);

        List<Integer> datos = new ArrayList<>();

        for (String token : tokens) {
            datos.add(Integer.valueOf(token));
        }

        return datos;
    }

    @Override
    public String toString(Collection<Integer> integerCollection) {
        Collection<String> strings = Collections.singleton(integerCollection.toString());
        return strings.stream().collect( Collectors.joining(delimiter) );
    }
}
