package com.intcheck.app.controller;

import com.intcheck.app.modelo.Publicacion;
import com.intcheck.app.modelo.Tag;
import com.intcheck.app.services.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PublicacionController {

	@Autowired
	private PublicacionService publicacionService;

	@GetMapping("/publicaciones")
	public List<Publicacion> listarTodasLasPublicaciones() {
		return publicacionService.listarTodas();
	}

	@GetMapping("/publicaciones/pagina")
	public Page<Publicacion> listarPaginadas(Pageable pageable) {
		return publicacionService.findAll(pageable);
	}

	@GetMapping("/publicaciones/{id}")
	public Publicacion obtenerPublicacionPorId(@PathVariable Long id) {
		return publicacionService.obtenerPorId(id).orElse(null);
	}

	@GetMapping("/publicaciones/usuario/{nombreUsuario}")
	public Page<Publicacion> obtenerPublicacionesPorUsuario(
			@PathVariable String nombreUsuario,
			Pageable pageable) {
		return publicacionService.findByNombreUsuario(nombreUsuario, pageable);
	}

	@PostMapping("/publicaciones")
	public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
		return publicacionService.crear(publicacion);
	}

	@PutMapping("/publicaciones/{id}")
	public Publicacion actualizarPublicacion(@PathVariable Long id, @RequestBody Publicacion publicacion) {
		return publicacionService.actualizar(id, publicacion);
	}

	@PostMapping("/publicaciones/archivos")
	public Publicacion crearPublicacionConArchivo(
			@RequestPart("texto") String texto,
			@RequestPart("tag") String tagId,
			@RequestPart("nombre_usuario") String nombreUsuario,
			@RequestPart("archivos") MultipartFile archivo) throws IOException {
		return publicacionService.crearConArchivo(texto, tagId, nombreUsuario, archivo);
	}

	@DeleteMapping("/publicaciones/{id}")
	public void eliminarPublicacion(@PathVariable Long id) {
		publicacionService.eliminarPorId(id);
	}
}