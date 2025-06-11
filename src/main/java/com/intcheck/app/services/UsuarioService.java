package com.intcheck.app.services;

import com.intcheck.app.controller.AuthController;
import com.intcheck.app.modelo.Usuario;
import com.intcheck.app.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

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

    public Usuario modificarUsuario(Usuario usuario) {
        if (usuarioRepo.existsById(usuario.getNombre_usuario())) {
            Usuario usuarioActual = usuarioRepo.findById(usuario.getNombre_usuario()).orElse(null);
            try {
                Usuario usuarioModificado = new Usuario();
                usuarioModificado.setNombre_usuario(usuarioActual.getNombre_usuario());
                usuarioModificado.setEmail(usuario.getEmail());
                usuarioModificado.setPassword(usuarioActual.getPassword());
                usuarioModificado.setApellidos(usuario.getApellidos());
                usuarioModificado.setSexo(usuario.getSexo());
                usuarioModificado.setFecha_nacimiento(usuario.getFecha_nacimiento());
                usuarioModificado.setEs_admin(usuario.getEs_admin());
                return usuarioRepo.save(usuarioModificado);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }

    public List<Usuario> buscarUsuarios(Usuario filtro) {
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        return listaUsuarios.stream()
                .filter(u -> filtro.getNombre_usuario() == null || filtro.getNombre_usuario().isBlank() || u.getNombre_usuario().equalsIgnoreCase(filtro.getNombre_usuario()))
                .filter(u -> filtro.getEmail() == null || filtro.getEmail().isBlank() || u.getEmail().equalsIgnoreCase(filtro.getEmail()))
                .filter(u -> filtro.getApellidos() == null || filtro.getApellidos().isBlank() || u.getApellidos().equalsIgnoreCase(filtro.getApellidos()))
                .filter(u -> filtro.getSexo() == null || filtro.getSexo().isBlank() || u.getSexo().equalsIgnoreCase(filtro.getSexo()))
                .filter(u -> filtro.getFecha_nacimiento() == null || u.getFecha_nacimiento().equals(filtro.getFecha_nacimiento()))
                .filter(u -> filtro.getEs_admin() == null || u.getEs_admin().equals(filtro.getEs_admin()))
                .toList();
    }

    public Page<Usuario> obtenerPaginaUsuariosFiltrados(Usuario filtro, int page, int size) {
        filtro = limpiarFiltro(filtro);
        List<Usuario> filtrados = buscarUsuarios(filtro);
        int total = filtrados.size();
        int start = (page - 1) * size;
        int end = Math.min(start + size, total);
        List<Usuario> pagina = (start >= 0 && start < total) ? filtrados.subList(start, end) : List.of();
        return new PageImpl<>(pagina, PageRequest.of(page - 1, size), total);
    }

    public Usuario limpiarFiltro(Usuario filtro) {
        if (filtro.getNombre_usuario() == "") {
            filtro.setNombre_usuario(null);
        }
        if (filtro.getEmail() == "") {
            filtro.setEmail(null);
        }
        if (filtro.getApellidos() == "") {
            filtro.setApellidos(null);
        }
        if (filtro.getSexo() == "") {
            filtro.setSexo(null);
        }
        if (filtro.getFecha_nacimiento() == "") {
            filtro.setFecha_nacimiento(null);
        }
        if (filtro.getEs_admin() == "") {
            filtro.setEs_admin(null);
        }
        return filtro;
    }

    public Usuario actualizarImagenPerfil(String nombreUsuario, MultipartFile imagen) throws IOException {
        Optional<Usuario> usuarioOpt = usuarioRepo.findById(nombreUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            String basePath = "C:" + File.separator + "dev" + File.separator + "uploads" + File.separator + "perfiles";
            File userDir = new File(basePath, nombreUsuario.replace('.', '_'));
            if (!userDir.exists()) {
                userDir.mkdirs();
            }
            String nombreArchivo = nombreUsuario.replace('.', '_') + "_" + imagen.getOriginalFilename();
            String ruta = userDir.getPath() + File.separator + nombreArchivo;
            File dest = new File(ruta);
            imagen.transferTo(dest);

            // Guarda la ruta o el nombre del archivo en la base de datos
            usuario.setImagen_perfil(ruta);
            return usuarioRepo.save(usuario);
        }
        return null;
    }

    public Usuario actualizarLaImagenPerfil(String nombreUsuario, MultipartFile imagen) throws IOException {
        Optional<Usuario> usuarioOpt = usuarioRepo.findById(nombreUsuario);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            String basePath = "C:" + File.separator + "dev" + File.separator + "uploads" + File.separator + "perfiles";
            File userDir = new File(basePath, nombreUsuario.replace('.', '_'));
            if (!userDir.exists()) {
                userDir.mkdirs();
            }

            // Obtener la extensión original del archivo
            String extension = "";
            String nombreOriginal = imagen.getOriginalFilename();
            int i = nombreOriginal.lastIndexOf('.');
            if (i > 0) {
                extension = nombreOriginal.substring(i);
            }

            // Usar un nombre fijo para la imagen de perfil
            String nombreArchivo = "perfil" + extension;
            String ruta = userDir.getPath() + File.separator + nombreArchivo;
            File dest = new File(ruta);

            // Guardar (y reemplazar si ya existe)
            imagen.transferTo(dest);

            usuario.setImagen_perfil(ruta);
            return usuarioRepo.save(usuario);
        }
        return null;
    }
}
