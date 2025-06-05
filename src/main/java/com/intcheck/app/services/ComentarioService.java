package com.intcheck.app.services;

import com.intcheck.app.modelo.Comentario;
import com.intcheck.app.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Comentario crear(Comentario comentario) {
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
                    comentario.setPublicacion(comentarioActualizado.getPublicacion());
                    comentario.setUsuario(comentarioActualizado.getUsuario());
                    return comentarioRepo.save(comentario);
                })
                .orElse(null);
    }
}