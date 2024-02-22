package com.intcheck.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intcheck.app.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
