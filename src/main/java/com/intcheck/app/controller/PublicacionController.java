package com.intcheck.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intcheck.app.modelo.Publicacion;
import com.intcheck.app.repository.PublicacionRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PublicacionController {

	@Autowired
	private PublicacionRepository publicacionRepo;
	
	@GetMapping("/publicaciones")
	public List<Publicacion> listarTodasLasPublicaciones() {
		return publicacionRepo.findAll();
	}
}
