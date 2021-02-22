package com.mpersd.spring.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mpersd.spring.datos.repositorio.ArtistaRepository;
import com.mpersd.spring.dominio.Artista;

@Service @Transactional
public class ArtistaBoService implements IArtistaBo {
	@Autowired private ArtistaRepository adao; 
	
	public ArtistaBoService() {}

	@Override
	public void create(Artista e) {
		adao.save(e);
	}

	@Override
	public void update(Artista e) {
		Optional<Artista> opt = adao.findById(e.getId());
		if(opt.isPresent()){
			Artista a = opt.get();
			a.setFotoUrl(e.getFotoUrl());
			a.setNombre(e.getNombre());
			a.setSitioUrl(e.getSitioUrl());
			adao.save(a);
		}
	}

	@Override
	public void delete(int id) {
		adao.deleteById(id);
	}

	@Override
	public Artista findById(int id) {
		Optional<Artista> opt = adao.findById(id);
		if(opt.isPresent()) return opt.get();
		return null;
	}

	@Override
	public List<Artista> findAll() {
		List<Artista> lista = new ArrayList<>();
		adao.findAll().forEach(lista::add);
		return lista;
	}

	@Override
	public Artista findByNombre(String nombre) {
		return adao.buscarPorNombre(nombre);
	}

}
