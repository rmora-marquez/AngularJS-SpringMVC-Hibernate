package com.mpersd.spring.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="generos")
@NamedQuery(name="Genero.findAll", query="SELECT g FROM Genero g")
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	//bi-directional many-to-one association to Album
	@OneToMany(mappedBy="genero",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Album> albumes;

	public Genero() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Album> getAlbumes() {
		return this.albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}

	public Album addAlbume(Album albume) {
		getAlbumes().add(albume);
		albume.setGenero(this);

		return albume;
	}

	public Album removeAlbume(Album albume) {
		getAlbumes().remove(albume);
		albume.setGenero(null);

		return albume;
	}

}