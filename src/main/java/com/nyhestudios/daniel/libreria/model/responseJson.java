package com.nyhestudios.daniel.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public record responseJson(
        @JsonAlias("count") Number count,
       @JsonAlias("results") List<DatosLibro> books
) {
}
