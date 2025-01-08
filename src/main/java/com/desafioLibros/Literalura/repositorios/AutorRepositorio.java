package com.desafioLibros.Literalura.repositorios;

import com.desafioLibros.Literalura.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreContainsIgnoreCase(String nombreAutor);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :segundaFecha AND (a.fechaDeDeceso IS NULL OR a.fechaDeDeceso >= :primeraFecha) ORDER BY a.fechaDeNacimiento")
    List<Autor> buscarAutorVivoEnDeterminadaFecha(Integer primeraFecha, Integer segundaFecha);

    @Query("SELECT a.nombre, COUNT(l.titulo) FROM Autor a JOIN Libros l ON a.id = l.id GROUP BY a.nombre ORDER BY 2 DESC")
    List<Autor> consultarCantidadDeLibrosPorAutor();
}
