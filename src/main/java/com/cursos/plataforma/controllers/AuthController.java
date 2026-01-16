package com.cursos.plataforma.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.plataforma.models.Usuario;
import com.cursos.plataforma.services.AuthService;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("api/auth")

public class AuthController {
    @Autowired
    private AuthService servicio;

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuarioLogin){
        return servicio.login(usuarioLogin);
    }
    
}
