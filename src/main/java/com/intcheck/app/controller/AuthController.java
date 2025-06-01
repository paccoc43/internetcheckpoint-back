package com.intcheck.app.controller;

import com.intcheck.app.modelo.AuthRequest;
import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Usuario usuarioAutenticado = authService.autenticar(authRequest.getUsuario(), authRequest.getPassword());
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
