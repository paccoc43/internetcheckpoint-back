package com.intcheck.app.controller;

import java.util.List;

import com.intcheck.app.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.intcheck.app.modelo.Usuario;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioService.listarTodos();
	}

	@GetMapping("/usuarios/{id}")
	public Usuario obtenerUsuarioPorId(@PathVariable String id) {
		return usuarioService.obtenerPorId(id).orElse(null);
	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable String id) {
		usuarioService.eliminarPorId(id);
	}

	@PutMapping("/usuarios/{id}")
	public Usuario modificarDatosUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
		return usuarioService.modificarUsuario(id, usuario);
	}
}
