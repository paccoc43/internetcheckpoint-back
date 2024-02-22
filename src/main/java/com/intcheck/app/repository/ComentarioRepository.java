package com.intcheck.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intcheck.app.modelo.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{

	
	
}
