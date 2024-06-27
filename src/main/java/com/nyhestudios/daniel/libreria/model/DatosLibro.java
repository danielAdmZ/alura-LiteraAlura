package com.nyhestudios.daniel.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

        @JsonAlias("id") Number id_WebLibro,
        @JsonAlias("title") String Title,
        @JsonAlias("authors") List<DataAutores> autores,
        @JsonAlias("languages") List<DataLenguajes> languages,
        @JsonAlias("media_type") String media_type
) {
}
