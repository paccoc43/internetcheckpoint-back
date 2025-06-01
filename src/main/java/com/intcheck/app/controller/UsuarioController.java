package com.intcheck.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@GetMapping("/usuarios")
	public List<Usuario> listarTodosLosUsuarios() {
		return usuarioRepo.findAll();
	}

	//obtiene un usuario utilizando su id
	@GetMapping("/usuarios/{id}")
	public Usuario obtenerUsuarioPorId(@PathVariable String id) {
		return usuarioRepo.findById(id).orElse(null);
	}

	@DeleteMapping("/usuarios/{id}")
	public void eliminarUsuario(@PathVariable String id) {
		usuarioRepo.deleteById(id);
	}

	@PutMapping("/usuarios/{id}")
	public Usuario actualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
		if (usuarioRepo.existsById(id)) {
			Usuario usuarioModificado = new Usuario();
			// actualiza los campos del usuario con los datos proporcionados

			usuarioModificado.setNombre_usuario(usuario.getNombre_usuario());
			usuarioModificado.setEmail(usuario.getEmail());
			usuarioModificado.setPassword(usuario.getPassword());
//			usuarioModificado.setFecha_creacion(usuario.getFecha_creacion());
			usuarioModificado.setApellidos(usuario.getApellidos());
			usuarioModificado.setSexo(usuario.getSexo());
			usuarioModificado.setFecha_nacimiento(usuario.getFecha_nacimiento());
			usuarioModificado.setEs_admin(usuario.getEs_admin());
			return usuarioRepo.save(usuarioModificado);
		} else {
			return null;
		}
	}
}
