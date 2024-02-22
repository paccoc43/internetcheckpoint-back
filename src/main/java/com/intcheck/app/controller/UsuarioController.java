package com.intcheck.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepo.findAll();
	}
}
