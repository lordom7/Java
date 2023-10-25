package com.ecodeup.biblioteca.biblioteca.model;

import com.ecodeup.biblioteca.biblioteca.dto.AutorDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombres;
    private String apellidos;
    private String telefono;
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor(AutorDTO autorDTO) {
        this.id = autorDTO.getId();
        this.nombres = autorDTO.getNombres();
        this.apellidos = autorDTO.getApellidos();
        this.telefono = autorDTO.getTelefono();
    }
}

