package com.nyhestudios.daniel.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAutores(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Number birth_year,
        @JsonAlias("death_year") Number death_year
) {
}
