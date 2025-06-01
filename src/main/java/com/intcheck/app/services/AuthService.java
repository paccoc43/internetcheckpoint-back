package com.intcheck.app.services;

import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String nombreUsuario, String password) {
        return usuarioRepository.findById(nombreUsuario)
                .filter(usuario -> usuario.getPassword().equals(password))
                .orElse(null);
    }

    public boolean registrar(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getNombre_usuario())) {
            return false;
        }
        usuarioRepository.save(usuario);
        return true;
    }
}
