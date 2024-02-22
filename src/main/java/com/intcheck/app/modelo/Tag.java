package com.intcheck.app.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@Column(name = "id_tag",nullable = false, unique = true)
	private Long id_tag;
	
	@Column(name = "nombre", length = 25)
	private String nombre;
	
	@Column(name = "fuente", length = 45)
	private String fuente;
	
	@Column(name = "color", length = 45)
	private String color;

	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "emoji", length = 20)
	private String emoji;

	public Long getId_tag() {
		return id_tag;
	}

	public void setId_tag(Long id_tag) {
		this.id_tag = id_tag;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmoji() {
		return emoji;
	}

	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	
	
}
