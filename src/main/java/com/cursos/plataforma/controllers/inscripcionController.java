package com.cursos.plataforma.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.plataforma.models.Inscripcion;
import com.cursos.plataforma.repositories.InscripcionRepository;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/api/inscripciones")

public class inscripcionController {
    @Autowired
    private InscripcionRepository repositorio;

    @PostMapping
    public Inscripcion guardaInscripcion(@RequestBody Inscripcion inscripcion){
        return repositorio.save(inscripcion);
    }
}
