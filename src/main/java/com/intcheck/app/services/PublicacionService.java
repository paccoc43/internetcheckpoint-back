package com.intcheck.app.services;

import com.intcheck.app.modelo.Publicacion;
import com.intcheck.app.modelo.Tag;
import com.intcheck.app.repository.PublicacionRepository;
import com.intcheck.app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepo;

    @Autowired
    private TagRepository tagRepo;

    public List<Publicacion> listarTodas() {
        return publicacionRepo.findAllByOrderByFechaPublicacionDesc();
    }

    public Page<Publicacion> findAll(Pageable pageable) {
        return publicacionRepo.findAllByOrderByFechaPublicacionDesc(pageable);
    }

    public Optional<Publicacion> obtenerPorId(Long id) {
        return publicacionRepo.findById(id);
    }

    public Publicacion crear(Publicacion publicacion) {
        if (publicacion.getTag() != null && publicacion.getTag().getId_tag() != null) {
            Tag tag = tagRepo.findById(publicacion.getTag().getId_tag()).orElse(null);
            publicacion.setTag(tag);
        }
        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        publicacion.setFecha_publicacion(fechaActual);
        return publicacionRepo.save(publicacion);
    }

    public Page<Publicacion> findByNombreUsuario(String nombreUsuario, Pageable pageable) {
        return publicacionRepo.findByNombreUsuarioOrderByFechaPublicacionDesc(nombreUsuario, pageable);
    }

    public void eliminarPorId(Long id) {
        publicacionRepo.deleteById(id);
    }

    public Publicacion actualizar(Long id, Publicacion publicacionActualizada) {
        return publicacionRepo.findById(id)
                .map(publicacion -> {
                    publicacion.setFecha_publicacion(publicacionActualizada.getFecha_publicacion());
                    publicacion.setContenido(publicacionActualizada.getContenido());
                    publicacion.setNombre_usuario(publicacionActualizada.getNombre_usuario());
                    publicacion.setTag(publicacionActualizada.getTag());
                    return publicacionRepo.save(publicacion);
                })
                .orElse(null);
    }
}