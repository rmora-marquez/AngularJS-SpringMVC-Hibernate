package com.mpersd.spring.negocio;

import java.util.List;

import com.mpersd.spring.dominio.Album;

public interface IAlbumBo {

	void create(Album e);
	void update(Album e);
	void delete(int id);
	
	Album findById(int id);
	List<Album> findAll();
}
