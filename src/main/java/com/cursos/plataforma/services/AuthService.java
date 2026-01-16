package com.cursos.plataforma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.plataforma.models.Usuario;
import com.cursos.plataforma.repositories.UsuarioRepository;

@Service
public class AuthService {
    
    @Autowired
    private UsuarioRepository repositorio;

    public Usuario login(Usuario usuarioLogin) {
        Usuario usuarioEncontrado = repositorio.findByNombreUsuario(usuarioLogin.getNombreUsuario());

        if(usuarioEncontrado != null && usuarioEncontrado.getContraseña().equals(usuarioLogin.getContraseña())){
            return usuarioEncontrado;
        } else {
            return null;
        }
    }
}
