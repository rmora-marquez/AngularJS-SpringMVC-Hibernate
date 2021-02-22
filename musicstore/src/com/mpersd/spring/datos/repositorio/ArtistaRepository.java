package com.mpersd.spring.datos.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mpersd.spring.dominio.Artista;

public interface ArtistaRepository 
		extends CrudRepository<Artista, Integer> {

	@Query("SELECT a FROM Artista a WHERE a.nombre = ?1")
	Artista buscarPorNombre(String nombre);
}
