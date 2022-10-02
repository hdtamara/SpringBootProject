package com.cursojava.curso.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@Data
public class Usuario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono", nullable = true)
    private String telefono;
    @Column(name = "password")
    private String password;


}
