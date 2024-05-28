package es.upsa.dasi.trabajo2.gateway.adapters.input.rest.providers;


import es.upsa.dasi.trabajo2.gateway.adapters.input.rest.providers.annotations.Delimiter;
import es.upsa.dasi.trabajo2.gateway.adapters.input.rest.providers.paramconverters.CollectionParamConverter;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

@Provider
public class CollectionParamConverterProvider implements ParamConverterProvider {
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> aClass, Type type, Annotation[] annotations) {

        if (type instanceof ParameterizedType parameterizedType)
        {
            Class rawClass = (Class) parameterizedType.getRawType();
            if (Collection.class.isAssignableFrom( rawClass )){
                Class geneticClass0 = (Class) parameterizedType.getActualTypeArguments()[0];
                if ( Integer.class == geneticClass0){

                    String delimiter = Arrays.stream(annotations)
                            .filter(Delimiter.class::isInstance)
                            .map(Delimiter.class::cast)
                            .findFirst()
                            .map(Delimiter::value)
                            .orElse(Delimiter.DEFAULT_DELIMITER);

                    return (ParamConverter<T>) new CollectionParamConverter(delimiter);
                }
            }

        }

        return null;
    }
}
