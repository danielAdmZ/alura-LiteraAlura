package com.nyhestudios.daniel.libreria.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int birth_year;
    private int death_year;

    @OneToMany(mappedBy = "autores", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Libro> libros;


    public Autores() {

    }


    public Autores(DataAutores autores) {
        this.nombre = autores.name();
        this.birth_year = autores.birth_year();
        this.death_year = autores.death_year();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    @Override
    public String toString() {
        return "-----------\nAutores\n" +
                "Año de muerte =" + death_year +
                " \nAño de nacimiento =" + birth_year +
                "\n nombre=" + nombre + "\n --------------";
    }
}
