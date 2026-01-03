package com.cursos.plataforma.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.plataforma.models.Usuario;
import com.cursos.plataforma.repositories.UsuarioRepository;
@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins="*")
public class AuthController {
    @Autowired
    private UsuarioRepository repositorio;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuarioLogin){
        Usuario usuarioEncontrado = repositorio.findByNombreUsuario(usuarioLogin.getNombreUsuario());

        if(usuarioEncontrado != null && usuarioEncontrado.getContraseña().equals(usuarioLogin.getContraseña())){
            return usuarioEncontrado;
        }else{
            return null;
        }



    }
    
}
