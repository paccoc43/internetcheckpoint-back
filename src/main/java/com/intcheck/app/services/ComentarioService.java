package com.intcheck.app.services;

import com.intcheck.app.modelo.Comentario;
import com.intcheck.app.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepo;

    public List<Comentario> listarTodos() {
        return comentarioRepo.findAll();
    }

    public Optional<Comentario> obtenerPorId(Long id) {
        return comentarioRepo.findById(id);
    }

    public List<Comentario> listarPorPublicacion(Long idPublicacion) {
        return comentarioRepo.findByIdPublicacionOrderByFechaComentarioDesc(idPublicacion);
    }

    public Comentario crear(Comentario comentario) {
        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        comentario.setFecha_comentario(fechaActual);
        return comentarioRepo.save(comentario);
    }

    public void eliminarPorId(Long id) {
        comentarioRepo.deleteById(id);
    }

    public Comentario actualizar(Long id, Comentario comentarioActualizado) {
        return comentarioRepo.findById(id)
                .map(comentario -> {
                    comentario.setContenido(comentarioActualizado.getContenido());
                    comentario.setFecha_comentario(comentarioActualizado.getFecha_comentario());
                    comentario.setId_publicacion(comentarioActualizado.getId_publicacion());
                    comentario.setNombre_usuario(comentarioActualizado.getNombre_usuario());
                    return comentarioRepo.save(comentario);
                })
                .orElse(null);
    }
}