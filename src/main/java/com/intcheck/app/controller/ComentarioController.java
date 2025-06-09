package com.intcheck.app.controller;

import com.intcheck.app.modelo.Comentario;
import com.intcheck.app.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;

	@GetMapping("/comentarios")
	public List<Comentario> listarTodosLosComentarios() {
		return comentarioService.listarTodos();
	}

	@GetMapping("/comentarios/{id}")
	public Comentario obtenerComentarioPorId(@PathVariable Long id) {
		return comentarioService.obtenerPorId(id).orElse(null);
	}

	@GetMapping("/comentarios/publicacion/{id_publicacion}")
	public List<Comentario> obtenerComentariosPorPublicacion(@PathVariable Long id_publicacion) {
		return comentarioService.listarPorPublicacion(id_publicacion);
	}

	@PostMapping("/comentarios")
	public Comentario crearComentario(@RequestBody Comentario comentario) {
		return comentarioService.crear(comentario);
	}

	@PutMapping("/comentarios/{id}")
	public Comentario actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
		return comentarioService.actualizar(id, comentario);
	}

	@DeleteMapping("/comentarios/{id}")
	public void eliminarComentario(@PathVariable Long id) {
		comentarioService.eliminarPorId(id);
	}
}