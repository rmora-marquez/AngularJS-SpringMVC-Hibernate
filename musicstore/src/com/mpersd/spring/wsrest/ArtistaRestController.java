package com.mpersd.spring.wsrest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mpersd.spring.dominio.Artista;
import com.mpersd.spring.negocio.IArtistaBo;

@RestController
@RequestMapping("/api/artista")
public class ArtistaRestController {
	@Autowired private IArtistaBo abo;
	
	public ArtistaRestController() {}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artista>> findAllGet(){
		List<Artista> lista = abo.findAll();
		if(lista.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
		return new ResponseEntity<>(lista,HttpStatus.OK); //200
	}
	
	@GetMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> findById(@PathVariable("id") int id){
		Artista art = abo.findById(id);
		if(art == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
		return new ResponseEntity<>(art,HttpStatus.OK); // 200
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createPost(@RequestBody Artista art){
		if( abo.findByNombre(art.getNombre()) == null ){
			abo.create(art);
			return new ResponseEntity<>(HttpStatus.CREATED); // 201
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT); // 409
	}
	
	@PutMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> updatePut(@PathVariable("id") int id,
			@RequestBody Artista art){
		Artista a = abo.findById(id);
		if(a == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
		if(a.getId() != art.getId()) return new ResponseEntity<>(HttpStatus.CONFLICT); //409
		abo.update(art);
		return new ResponseEntity<Artista>(art,HttpStatus.OK); //200
	}
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> removeDelete(@PathVariable("id") int id){
		if(abo.findById(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
		abo.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
