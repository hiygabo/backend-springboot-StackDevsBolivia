package com.cursos.plataforma.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursos.plataforma.models.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer>{
    
}
