package com.intcheck.app.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario",
		uniqueConstraints = @UniqueConstraint(name = "uq_comentario_nombre_usuario", columnNames = "nombre_usuario"),
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

	@ManyToOne
	@JoinColumn(name = "id_publicacion", referencedColumnName = "id_publicacion", nullable = false,
			foreignKey = @ForeignKey(name = "fk_comentario_publicacion"))
	private Publicacion publicacion;

	@ManyToOne
	@JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario", nullable = false,
			foreignKey = @ForeignKey(name = "fk_comentario_usuario"))
	private Usuario usuario;

	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;

	@Column(name = "fecha_comentario", length = 255, nullable = false)
	private String fecha_comentario;

	// Getters y setters

	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	@Override
	public String toString() {
		return "Comentario{" +
				"id_comentario=" + id_comentario +
				", publicacion=" + publicacion.getId_publicacion() +
				", usuario=" + usuario.getNombre_usuario() +
				", contenido='" + contenido + '\'' +
				", fecha_comentario='" + fecha_comentario + '\'' +
				'}';
	}
}