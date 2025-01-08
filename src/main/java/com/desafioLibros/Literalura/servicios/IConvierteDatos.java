package com.desafioLibros.Literalura.servicios;

public interface IConvierteDatos {
    <T> T convertirDatos(String json, Class<T> clase);
}
