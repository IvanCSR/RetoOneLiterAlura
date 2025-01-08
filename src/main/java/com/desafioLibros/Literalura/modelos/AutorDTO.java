package com.desafioLibros.Literalura.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(
        @JsonAlias("name") String nombreAutor,
        @JsonAlias("birth_year") String fechaNacimiento,
        @JsonAlias("death_year") String fechaDeceso
) {
}
