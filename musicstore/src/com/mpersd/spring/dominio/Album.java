package com.mpersd.spring.dominio;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="albumes")
@NamedQuery(name="Album.findAll", query="SELECT a FROM Album a")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date lanzamiento;

	private String portadaUrl;

	private Double precio;

	private String titulo;

	//bi-directional many-to-one association to Genero
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idGenero")
	private Genero genero;

	//bi-directional many-to-one association to Artista
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idArtista")
	private Artista artista;

	public Album() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getLanzamiento() {
		return this.lanzamiento;
	}

	public void setLanzamiento(Date lanzamiento) {
		this.lanzamiento = lanzamiento;
	}

	public String getPortadaUrl() {
		return this.portadaUrl;
	}

	public void setPortadaUrl(String portadaUrl) {
		this.portadaUrl = portadaUrl;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Artista getArtista() {
		return this.artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

}