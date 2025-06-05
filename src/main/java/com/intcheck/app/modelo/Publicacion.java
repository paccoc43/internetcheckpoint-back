package com.intcheck.app.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "publicacion",
		uniqueConstraints = @UniqueConstraint(name = "uq_publicacion_nombre_usuario", columnNames = "nombre_usuario"),
		indexes = {
				@Index(name = "idx_publicacion_nombre_usuario", columnList = "nombre_usuario"),
				@Index(name = "idx_publicacion_id_tag", columnList = "id_tag")
		}
)
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_publicacion", nullable = false, unique = true)
	private Long id_publicacion;

	@Column(name = "fecha_publicacion", length = 45)
	private String fecha_publicacion;

	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;

	@ManyToOne
	@JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario", nullable = false,
			foreignKey = @ForeignKey(name = "fk_publicacion_usuario"))
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_tag", referencedColumnName = "id_tag", foreignKey = @ForeignKey(name = "fk_publicacion_tag"))
	private Tag tag;

	// Getters y setters

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
}