package com.mpersd.spring.dominio;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="artistas")
@NamedQuery(name="Artista.findAll", query="SELECT a FROM Artista a")
public class Artista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String fotoUrl;

	private String nombre;

	private String sitioUrl;

	//bi-directional many-to-one association to Album
	@JsonIgnore
	@OneToMany(mappedBy="artista",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Album> albumes;

	public Artista() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFotoUrl() {
		return this.fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSitioUrl() {
		return this.sitioUrl;
	}

	public void setSitioUrl(String sitioUrl) {
		this.sitioUrl = sitioUrl;
	}

	public List<Album> getAlbumes() {
		return this.albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}

	public Album addAlbume(Album albume) {
		getAlbumes().add(albume);
		albume.setArtista(this);

		return albume;
	}

	public Album removeAlbume(Album albume) {
		getAlbumes().remove(albume);
		albume.setArtista(null);

		return albume;
	}

}