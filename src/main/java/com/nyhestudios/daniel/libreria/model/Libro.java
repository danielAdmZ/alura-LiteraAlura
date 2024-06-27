package com.nyhestudios.daniel.libreria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private Number id_libro;
    private String title;
    private String media_type;
    private String lenguaje_1;
    private String lenguaje_2;
public Libro(){

}

    public Libro(DatosLibro datosLibro) {
        this.id_libro = datosLibro.id_WebLibro();
        this.title = datosLibro.Title();
        this.media_type = datosLibro.media_type();
        try {
            this.lenguaje_1 = datosLibro.languages().get(0);
        }catch (RuntimeException e){
            this.lenguaje_1 = "Sin Lenguajes";
        }
        try {
            this.lenguaje_2 = datosLibro.languages().get(1);
        }catch (RuntimeException e){
            this.lenguaje_2 = datosLibro.languages().get(1);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLenguaje_1() {
        return lenguaje_1;
    }

    public void setLenguaje_1(String lenguaje_1) {
        this.lenguaje_1 = lenguaje_1;
    }

    public String getLenguaje_2() {
        return lenguaje_2;
    }

    public void setLenguaje_2(String lenguaje_2) {
        this.lenguaje_2 = lenguaje_2;
    }

    public Number getId_libro() {
        return id_libro;
    }

    public void setId_libro(Number id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id_libro=" + id_libro +
                ", title='" + title + '\'' +
                ", media_type='" + media_type + '\'' +
                '}';
    }
}


