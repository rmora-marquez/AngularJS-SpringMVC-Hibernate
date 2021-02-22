package com.mpersd.spring.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpersd.spring.datos.repositorio.AlbumRepository;
import com.mpersd.spring.dominio.Album;

@Service @Transactional
public class AlbumBoImp implements IAlbumBo {
	@Autowired
	private AlbumRepository adao;
	
	public AlbumBoImp() {
		System.out.println("AlbumBo creado por Spring");
	}

	@Override
	public void create(Album e) {
		adao.save(e);
	}

	@Override
	public void update(Album e) {
		Optional<Album> opt = adao.findById(e.getId());
		if(opt.isPresent()){
			Album a = opt.get();
			a.setArtista(e.getArtista());
			a.setGenero(a.getGenero());
			a.setLanzamiento(e.getLanzamiento());
			a.setTitulo(e.getTitulo());
			a.setPortadaUrl(e.getPortadaUrl());
			a.setPrecio(e.getPrecio());
			adao.save(a);			
		}
	}

	@Override
	public void delete(int id) {		
		adao.deleteById(id);
	}

	@Override
	public Album findById(int id) {
		Optional<Album> opt = adao.findById(id);
		if(opt.isPresent()){
			return opt.get();
		}
		return null;
	}

	@Override
	public List<Album> findAll() {
		Iterable<Album> iter = adao.findAll();
		List<Album> lista = new ArrayList<>();
		iter.forEach(lista::add);
		return lista;
	}

}
