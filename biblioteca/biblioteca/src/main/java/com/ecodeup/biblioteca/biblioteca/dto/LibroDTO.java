package com.ecodeup.biblioteca.biblioteca.dto;

import com.ecodeup.biblioteca.biblioteca.model.Libro;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class LibroDTO {
    private Integer id;
    private String isbn;
    private String nombre;
    private String editorial;
    private String genero;
    private int numeroPaginas;
    private BigDecimal precio;
    private LocalDate fechaEdicion;
    private AutorDTO autorDTO;
    private Integer  idAutor;

    public LibroDTO(Libro libro) {
        this.id = libro.getId();
        this.isbn = libro.getIsbn();
        this.nombre = libro.getNombre();
        this.editorial = libro.getEditorial();
        this.genero = libro.getGenero();
        this.numeroPaginas = libro.getNumeroPaginas();
        this.precio = libro.getPrecio();
        this.fechaEdicion = libro.getFechaEdicion();
        //this.autorDTO = new AutorDTO(libro.getAutor());
    }
}

