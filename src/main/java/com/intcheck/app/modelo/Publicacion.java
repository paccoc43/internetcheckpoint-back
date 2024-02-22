package com.intcheck.app.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="publicacion")
public class Publicacion {

	@Id
	@Column(name = "id_publicacion",nullable = false, unique = true)
	private Long id_publicacion;
	
	@Column(name = "fecha_publicacion", length = 45)
	private String fecha_publicacion;

	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;
	
	@Column(name = "nombre_usuario", length = 25, nullable = false, unique = true)
	private String nombre_usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_tag", nullable = true)
	private Tag id_tag ;

	public Long getId_publicacion() {
		return id_publicacion;
	}

	public void setId_publicacion(Long id_publicacion) {
		this.id_publicacion = id_publicacion;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public Tag getId_tag() {
		return id_tag;
	}

	public void setId_tag(Tag id_tag) {
		this.id_tag = id_tag;
	}
	
}	
