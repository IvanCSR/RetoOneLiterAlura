package com.desafioLibros.Literalura.repositorios;

import com.desafioLibros.Literalura.modelos.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepositorio extends JpaRepository<Libros, Integer> {
    boolean existsByTitulo(String titulo);
    List<Libros> findByIdioma(String idioma);
}
