package com.crud.first.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "library_name", nullable = false)
    private String nameLibrary;

    @Column(name = "author", nullable = false)
    private String author;

}
