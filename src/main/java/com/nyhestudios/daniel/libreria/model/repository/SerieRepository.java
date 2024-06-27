package com.nyhestudios.daniel.libreria.model.repository;

import com.nyhestudios.daniel.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Libro,Long> {
}
