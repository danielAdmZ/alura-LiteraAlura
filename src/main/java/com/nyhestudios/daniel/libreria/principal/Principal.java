package com.nyhestudios.daniel.libreria.principal;

import com.nyhestudios.daniel.libreria.model.*;
import com.nyhestudios.daniel.libreria.model.repository.AutoresRepository;
import com.nyhestudios.daniel.libreria.model.repository.SerieRepository;
import com.nyhestudios.daniel.libreria.service.ConsumoAPI;
import com.nyhestudios.daniel.libreria.service.ConvierteDatos;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConvierteDatos convierte = new ConvierteDatos();
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private String URL_Base = "https://gutendex.com/books/";
    private String Url = "http://gutendex.com/books?search=romeo%20and";
    private List<Libro> librosBuscados;
    private List<Autores> autoresBuscados;
    private List<DataAutores> autoresList;
    private SerieRepository repositorio;
    private AutoresRepository repositorioAutores;

    public Principal(SerieRepository repository, AutoresRepository repositoryAutores) {
        this.repositorio = repository;
        this.repositorioAutores = repositoryAutores;
    }

    public void menu() {
        menuMostrar();
    }


    public void menuMostrar() {
        boolean continuar=false;
        while (!continuar) {
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
                case "0":
                    continuar=true;
                    break;
                case "1":
                    guardarLibro();
                    break;

                case "2":
                    listarLibrosRegistrados();
                    break;
                case "3":
                    listarAutoresRegistrados();
                    break;
                case "4":
                    listarAutoresPorAnioVivo();
                    break;
                case "5":
                    listarLibrosPorIdioma();
                    break;
                default:
                    break;
            }
        }
    }

    private void listarAutoresPorAnioVivo() {
        System.out.println("Ingresa el año que deseas buscar");
        int anio;
        try {
           anio= teclado.nextInt();
           autoresBuscados = repositorioAutores.findByAnioVivo(anio);
        }catch (InputMismatchException e){
            System.out.println("Ingresa un año valido ");
        }


        if (autoresBuscados.isEmpty()){
            System.out.println("Ningun Autor encontrado");
        }else{
            autoresBuscados.stream().forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Escribe el Idioma que deseas buscar");
        System.out.println("""
                - en
                - fr
                - es
                """);
        String idioma = teclado.nextLine().toLowerCase();

        librosBuscados = repositorio.findByLenguaje(idioma);
        if(librosBuscados.isEmpty()){
            System.out.println("--------------\n\nNingun libro encontrado\n\n---------------");
        }else {
            System.out.println("Se localizaron "+ librosBuscados.size() + " Libros");
            librosBuscados.stream().forEach(System.out::println);
        }

    }

    private void listarAutoresRegistrados() {
        autoresBuscados = repositorioAutores.findAll();
        autoresBuscados.stream().forEach(System.out::println);
    }

    private void listarLibrosRegistrados() {
        librosBuscados = repositorio.findAll();
        librosBuscados.stream().forEach(System.out::println);
    }


    public DatosLibro buscarPorTitulo() {
        System.out.println("Ingresa el nombre del titulo que deseas buscar");
        String titulo = teclado.nextLine();
        int i = 0;
        var json = consumoAPI.obtenerDatos(URL_Base + "?search=" + titulo.replace(" ", "+"));
        responseJson datosJson = convierte.obtenerDatos(json, responseJson.class);
        System.out.println("EL SISTEMA ENCONTRÓ " + datosJson.count() + "POSIBLES RESULTADOS");
        datosJson.books().forEach(datosLibro -> System.out.println("------------\nID-Libro: " + datosLibro.id_WebLibro() + "\nTitulo del Libro: " + datosLibro.Title() + "\n----------------"));
        json = "";
        System.out.println("Ingresa el ID del libro que se desea guardar");
        String id_libro = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_Base + id_libro + "/");
        DatosLibro libro = convierte.obtenerDatos(json, DatosLibro.class);
        autoresList = libro.autores();
        return libro;
    }

    public void guardarLibro() {

        Libro libro1 = new Libro(buscarPorTitulo());

        try {
            repositorio.save(libro1);
            guardarAutor(libro1);
        }catch (DataIntegrityViolationException e){
            System.out.println("El libro que desea buscar no se encuentra disponible o ya se encuentra registrado");
        }



    }

    public void guardarAutor(Libro prueba){
        Libro libro = repositorio.findByid_libro(prueba.getId_libro()).get(0);
        libro.setAutores(new Autores(autoresList.get(0)));
        repositorio.save(libro);

    }



}
