package com.intcheck.app.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario",
		indexes = {
				@Index(name = "idx_comentario_nombre_usuario", columnList = "nombre_usuario"),
				@Index(name = "idx_comentario_id_publicacion", columnList = "id_publicacion")
		}
)
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_comentario", nullable = false, unique = true)
	private Long id_comentario;

	@Column(name = "id_publicacion", nullable = false)
	private Long idPublicacion;

	@Column(name = "nombre_usuario", length = 25, nullable = false)
	private String nombre_usuario;

	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;

	@Column(name = "fecha_comentario", length = 255, nullable = false)
	private String fechaComentario;

	// Getters y setters

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public Long getId_publicacion() {
		return idPublicacion;
	}

	public void setId_publicacion(Long idPublicacion) {
		this.idPublicacion = idPublicacion;
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
		return fechaComentario;
	}

	public void setFecha_comentario(String fechaComentario) {
		this.fechaComentario = fechaComentario;
	}

	@Override
	public String toString() {
		return "Comentario{" +
				"id_comentario=" + id_comentario +
				", id_publicacion=" + idPublicacion +
				", nombre_usuario='" + nombre_usuario + '\'' +
				", contenido='" + contenido + '\'' +
				", fecha_comentario='" + fechaComentario + '\'' +
				'}';
	}
}