package com.nyhestudios.daniel.libreria.model.repository;

import com.nyhestudios.daniel.libreria.model.Autores;
import com.nyhestudios.daniel.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Libro,Long> {

    //@Query(value = "INSERT INTO autores_libros (autores_id, libros_id) VALUES (:autores_id, :libros_id)", nativeQuery = true)
    //String insertRelation(Long autores_id, Long libros_id);
    @Query("SELECT l FROM Libro l WHERE l.id_libro =:id_libro")
    List<Libro> findByid_libro(Number id_libro);

    @Query("SELECT l FROM Libro l WHERE l.lenguaje_1 = :lenguaje OR l.lenguaje_2 = :lenguaje ")
    List<Libro> findByLenguaje(String lenguaje);


}
