package com.nyhestudios.daniel.libreria.model;

public class Autores {
    private String nombre;
    private Number birth_year;
    private Number Death_year;

    public Autores(){

    }


    public Autores(DataAutores autores) {
        this.nombre = autores.name();
        this.birth_year = autores.birth_year();
        Death_year = autores.death_year();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Number getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Number birth_year) {
        this.birth_year = birth_year;
    }

    public Number getDeath_year() {
        return Death_year;
    }

    public void setDeath_year(Number death_year) {
        Death_year = death_year;
    }
}
