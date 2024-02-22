package com.intcheck.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intcheck.app.modelo.Comentario;
import com.intcheck.app.repository.ComentarioRepository;

@RestController
@RequestMapping("/api/v1/")
public class ComentarioController {

	@Autowired
	private ComentarioRepository comentarioRepo;
	
	@GetMapping("/comentarios")
	public List<Comentario> listarTodasLasPublicaciones() {
		return comentarioRepo.findAll();
	}
}
