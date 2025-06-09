// src/main/java/com/intcheck/app/repository/PublicacionRepository.java
package com.intcheck.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.intcheck.app.modelo.Publicacion;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {
    Page<Publicacion> findByNombreUsuario(String nombreUsuario, Pageable pageable);
}