package com.intcheck.app.controller;

import java.util.List;

import com.intcheck.app.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.intcheck.app.modelo.Tag;
import com.intcheck.app.repository.TagRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TagController {

	@Autowired
	private TagService tagService;

	@GetMapping("/tags")
	public List<Tag> listarTodosLosTags() {
		return tagService.listarTodos();
	}

	@GetMapping("/tags/{id}")
	public Tag obtenerTagPorId(@PathVariable Long id) {
		return tagService.obtenerPorId(id).orElse(null);
	}

	@PostMapping("/tags")
	public Tag crearTag(@RequestBody Tag tag) {
		return tagService.crear(tag);
	}

	@PutMapping("/tags/{id}")
	public Tag actualizarTag(@PathVariable Long id, @RequestBody Tag tag) {
		return tagService.actualizar(id, tag);
	}

	@DeleteMapping("/tags/{id}")
	public void eliminarTag(@PathVariable Long id) {
		tagService.eliminarPorId(id);
	}
}
