package com.intcheck.app.services;

import com.intcheck.app.modelo.Tag;
import com.intcheck.app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepo;

    public List<Tag> listarTodos() {
        return tagRepo.findAll();
    }

    public Optional<Tag> obtenerPorId(Long id) {
        return tagRepo.findById(id);
    }

    public Tag crear(Tag tag) {
        return tagRepo.save(tag);
    }

    public void eliminarPorId(Long id) {
        tagRepo.deleteById(id);
    }

    public Tag actualizar(Long id, Tag tagActualizado) {
        return tagRepo.findById(id)
                .map(tag -> {
                    tag.setNombre(tagActualizado.getNombre());
                    tag.setFuente(tagActualizado.getFuente());
                    tag.setColor(tagActualizado.getColor());
                    tag.setDescripcion(tagActualizado.getDescripcion());
                    tag.setEmoji(tagActualizado.getEmoji());
                    tag.setNombre_usuario(tagActualizado.getNombre_usuario());
                    return tagRepo.save(tag);
                })
                .orElse(null);
    }
}