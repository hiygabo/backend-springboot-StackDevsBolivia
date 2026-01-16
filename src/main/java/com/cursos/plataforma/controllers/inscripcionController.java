package com.cursos.plataforma.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.plataforma.models.Inscripcion;
import com.cursos.plataforma.services.InscripcionService;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/api/inscripciones")

public class inscripcionController {
    @Autowired
    private InscripcionService servicio;

    @PostMapping
    public Inscripcion guardaInscripcion(@RequestBody Inscripcion inscripcion){
        return servicio.guardarInscripcion(inscripcion);
    }
}
