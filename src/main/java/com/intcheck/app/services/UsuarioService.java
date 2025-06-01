package com.intcheck.app.services;

import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public List<Usuario> listarTodos() {
        return usuarioRepo.findAll();
    }

    public Optional<Usuario> obtenerPorId(String id) {
        return usuarioRepo.findById(id);
    }

    public void eliminarPorId(String id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario modificarUsuario(String id, Usuario usuario) {
        if (usuarioRepo.existsById(id)) {
            Usuario usuarioModificado = new Usuario();
            usuarioModificado.setNombre_usuario(usuario.getNombre_usuario());
            usuarioModificado.setEmail(usuario.getEmail());
            usuarioModificado.setPassword(usuario.getPassword());
            usuarioModificado.setApellidos(usuario.getApellidos());
            usuarioModificado.setSexo(usuario.getSexo());
            usuarioModificado.setFecha_nacimiento(usuario.getFecha_nacimiento());
            usuarioModificado.setEs_admin(usuario.getEs_admin());
            return usuarioRepo.save(usuarioModificado);
        } else {
            return null;
        }
    }
}
