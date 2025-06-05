package com.intcheck.app.services;

import com.intcheck.app.modelo.Publicacion;
import com.intcheck.app.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepo;

    public List<Publicacion> listarTodas() {
        return publicacionRepo.findAll();
    }

    public Optional<Publicacion> obtenerPorId(Long id) {
        return publicacionRepo.findById(id);
    }

    public Publicacion crear(Publicacion publicacion) {
        return publicacionRepo.save(publicacion);
    }

    public void eliminarPorId(Long id) {
        publicacionRepo.deleteById(id);
    }

    public Publicacion actualizar(Long id, Publicacion publicacionActualizada) {
        return publicacionRepo.findById(id)
                .map(publicacion -> {
                    publicacion.setFecha_publicacion(publicacionActualizada.getFecha_publicacion());
                    publicacion.setContenido(publicacionActualizada.getContenido());
                    publicacion.setUsuario(publicacionActualizada.getUsuario());
                    publicacion.setTag(publicacionActualizada.getTag());
                    return publicacionRepo.save(publicacion);
                })
                .orElse(null);
    }
}