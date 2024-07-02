package com.nyhestudios.daniel.libreria.model.repository;

import com.nyhestudios.daniel.libreria.model.Autores;
import com.nyhestudios.daniel.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autores,Long> {


    @Query("SELECT a from Autores a WHERE a.death_year > :death_year AND a.birth_year < :death_year" )
    List<Autores> findByAnioVivo(Integer death_year);
}
