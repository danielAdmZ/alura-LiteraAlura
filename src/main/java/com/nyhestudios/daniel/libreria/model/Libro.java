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
    private
public Libro(){

}

    public Libro(DatosLibro datosLibro) {
        this.id_libro = datosLibro.id_WebLibro();
        this.title = datosLibro.Title();
        this.media_type = datosLibro.media_type();
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


