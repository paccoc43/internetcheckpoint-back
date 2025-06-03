package com.intcheck.app.controller;

import com.intcheck.app.modelo.AuthRequest;
import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.services.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Usuario usuarioAutenticado = authService.autenticar(authRequest.getUsuario(), authRequest.getPassword());
            if (usuarioAutenticado != null) {
                logger.info("Usuario autenticado: {}", usuarioAutenticado.getNombre_usuario());
                return ResponseEntity.ok(usuarioAutenticado);
            } else {
                return ResponseEntity.status(401).body("Credenciales incorrectas");
            }
        } catch (Exception e) {
            logger.error("Error al iniciar el servicio de autenticacion", e);
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
            logger.error("Error al iniciar el servicio de autenticacion", e);
            throw new RuntimeException("Error al iniciar el servicio de autenticacion", e);
        }
    }
}
