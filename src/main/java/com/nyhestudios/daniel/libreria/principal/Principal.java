package com.nyhestudios.daniel.libreria.principal;

import com.nyhestudios.daniel.libreria.model.*;
import com.nyhestudios.daniel.libreria.model.repository.SerieRepository;
import com.nyhestudios.daniel.libreria.service.ConsumoAPI;
import com.nyhestudios.daniel.libreria.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConvierteDatos convierte = new ConvierteDatos();
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private String URL_Base = "https://gutendex.com/books/";
    private String Url = "http://gutendex.com/books?search=romeo%20and";
    private SerieRepository repositorio;
    public Principal(SerieRepository repository) {
        this.repositorio = repository;
    }

    public void menu() {
        menuMostrar();
    }


    public void menuMostrar() {
        System.out.println("Seleciona una opción correcta en el menú");
        System.out.println("""
                    1.- Buscar libro por título
                    2.- Listar libros registrados
                    3.- Listar Autores registrados
                    4.- Listar autores vivos en un determinado año
                    5.- Listar libros por idioma
                    0- Salir            
                """);
        String option = teclado.nextLine();
        switch (option) {
            case "1":
                buscarPorTitulo();
                break;
            default:
                break;
        }
    }


    public void buscarPorTitulo() {
        System.out.println("Ingresa el nombre del titulo que deseas buscar");
        String titulo = teclado.nextLine();
        int i = 0;
        var json = consumoAPI.obtenerDatos(URL_Base + "?search=" + titulo.replace(" ", "+"));
        responseJson datosJson = convierte.obtenerDatos(json, responseJson.class);
        System.out.println("EL SISTEMA ENCONTRÓ " + datosJson.count() + "POSIBLES RESULTADOS");
        datosJson.books().forEach(datosLibro -> System.out.println("------------\nID-Libro: " + datosLibro.id_WebLibro() + "\nTitulo del Libro: " + datosLibro.Title() + "\n----------------"));
        json= "";
        System.out.println("Ingresa el ID del libro que se desea guardar");
        String id_libro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_Base + id_libro+"/");
        DatosLibro libro = convierte.obtenerDatos(json, DatosLibro.class);

        System.out.println(libro);
        Libro libro1 = new Libro(libro);
        System.out.println(libro1);
        //repositorio.save(libro1);
    }


    public void prueba() {
        var json = consumoAPI.obtenerDatos(URL_Base + "?search=romeo+and");
        responseJson datos = convierte.obtenerDatos(json, responseJson.class);
        System.out.println("El sistema encontró " + datos.count() + " Resultados");
        datos.books().forEach(datosLibro -> System.out.println("------------\n:" + datosLibro.id_WebLibro() + "\n" + datosLibro.Title() + "\n----------------"));

        //DatosLibro libro = datos.books().get(1);
        //System.out.println(libro);

    }

}
