package com.intcheck.app.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario {

	@Id
	@Column(name = "id_comentario",nullable = false, unique = true)
	private Long id_comentario;
	
	@Column(name = "id_publicacion", nullable = false, unique = true)
	private Long id_publicacion;
	
	@Column(name = "nombre_usuario", length = 25, nullable = false, unique = true)
	private String nombre_usuario;
	
	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;
	
	@Column(name = "fecha_comentario", nullable = false)
	private String fecha_comentario;

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public Long getId_publicacion() {
		return id_publicacion;
	}

	public void setId_publicacion(Long id_publicacion) {
		this.id_publicacion = id_publicacion;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getFecha_comentario() {
		return fecha_comentario;
	}

	public void setFecha_comentario(String fecha_comentario) {
		this.fecha_comentario = fecha_comentario;
	}
	
	
}
