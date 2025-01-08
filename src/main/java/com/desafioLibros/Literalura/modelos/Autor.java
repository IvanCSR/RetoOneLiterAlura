package com.desafioLibros.Literalura.modelos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    private String nombre;
    private Integer fechaDeNacimiento;
    private Integer fechaDeDeceso;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libros> librosDelAutor;

    public Autor(){

    }

    public Autor(AutorDTO datosAutor) {
        this.nombre = datosAutor.nombreAutor();
        this.fechaDeNacimiento = Integer.valueOf(datosAutor.fechaNacimiento());
        this.fechaDeDeceso = Integer.valueOf(datosAutor.fechaDeceso());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeDeceso() {
        return fechaDeDeceso;
    }

    public void setFechaDeDeceso(Integer fechaDeDeceso) {
        this.fechaDeDeceso = fechaDeDeceso;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }


    public List<String> getLibrosAutor() {
        return librosDelAutor.stream()
                .map(libro -> libro.getTitulo())
                .collect(Collectors.toList());
    }

    public List<Libros> getLibrosDelAutor() {
        return librosDelAutor;
    }

    public void setLibrosDelAutor(Libros libro){
        librosDelAutor = new ArrayList<>();
        librosDelAutor.add(libro);
        libro.setAutor(this);
    }

    @Override
    public String toString() {
        return
                "Autor: " + nombre  +
                        "\nFecha de Nacimiento: " + fechaDeNacimiento +
                        "\nFecha de Fallecimiento: " + fechaDeDeceso +
                        "\nLibros: " + getLibrosAutor() + "\n"
                ;

    }
}
