package com.mpersd.spring.negocio;

import java.util.List;
import com.mpersd.spring.dominio.Artista;

public interface IArtistaBo {
	void create(Artista e);
	void update(Artista e);
	void delete(int id);
	
	Artista findById(int id);
	List<Artista> findAll();	
	Artista findByNombre(String nombre);
}
