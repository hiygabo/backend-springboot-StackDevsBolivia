package com.cursos.plataforma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.plataforma.models.Inscripcion;
import com.cursos.plataforma.repositories.InscripcionRepository;

@Service
public class InscripcionService {
    
    @Autowired
    private InscripcionRepository repositorio;

    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        return repositorio.save(inscripcion);
    }
}
