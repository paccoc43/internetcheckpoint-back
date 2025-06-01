package com.intcheck.app.controller;

import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioAutenticado = authService.autenticar(usuario.getNombre_usuario(), usuario.getPassword());
            if (usuarioAutenticado != null) {
                return ResponseEntity.ok(usuarioAutenticado);
            } else {
                return ResponseEntity.status(401).body("Credenciales incorrectas");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar el servicio de autenticacion",e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        try {
            boolean registrado = authService.registrar(usuario);
            if (registrado) {
                return ResponseEntity.ok("Usuario registrado");
            } else {
                return ResponseEntity.badRequest().body("El usuario ya existe");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al iniciar el servicio de autenticacion", e);
        }
    }
}
