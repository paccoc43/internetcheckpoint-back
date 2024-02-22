package com.intcheck.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intcheck.app.modelo.Tag;
import com.intcheck.app.repository.TagRepository;

@RestController
@RequestMapping("/api/v1/")
public class TagController {

	@Autowired
	private TagRepository tagRepo;
	
	@GetMapping("/tags")
	public List<Tag> listarTodosLosTags() {
		return tagRepo.findAll();
	}
}
