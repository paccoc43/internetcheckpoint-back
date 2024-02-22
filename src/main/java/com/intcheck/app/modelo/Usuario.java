package com.intcheck.app.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
	@Column(name = "nombre_usuario", length = 25, nullable = false, unique = true)
	private String nombre_usuario;
	
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fecha_creacion")
	private String fecha_creacion;
	
	@Column(name = "apellidos", length = 100)
	private String apellidos;
	
	@Column(name = "sexo", length = 10)
	private String sexo;
	
	@Column(name = "fecha_nacimiento")
	private String fecha_nacimiento;
	
	@Column(name = "es_admin")
	private String es_admin;
	
	public Usuario() {
		
	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getEs_admin() {
		return es_admin;
	}

	public void setEs_admin(String es_admin) {
		this.es_admin = es_admin;
	}
}
