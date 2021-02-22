package com.mpersd.spring.datos.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.mpersd.spring.dominio.Album;

public interface AlbumRepository
		extends CrudRepository<Album, Integer> {

}
