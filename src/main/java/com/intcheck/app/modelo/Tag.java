package com.intcheck.app.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@Column(name = "id_tag", nullable = false, unique = true)
	private Long id_tag;

	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;

	@Column(name = "fuente", length = 45)
	private String fuente;

	@Column(name = "color", length = 45)
	private String color;

	@Column(name = "descripcion", length = 100)
	private String descripcion;

	@Column(name = "emoji", length = 20)
	private String emoji;

	@Column(name = "nombre_usuario", length = 25, nullable = false)
	private String nombre_usuario;

	// Getters y setters

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

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	@Override
	public String toString() {
		return "Tag{" +
				"id_tag=" + id_tag +
				", nombre='" + nombre + '\'' +
				", fuente='" + fuente + '\'' +
				", color='" + color + '\'' +
				", descripcion='" + descripcion + '\'' +
				", emoji='" + emoji + '\'' +
				", creador=" + nombre_usuario +
				'}';
	}
}