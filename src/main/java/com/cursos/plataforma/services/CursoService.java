package com.cursos.plataforma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursos.plataforma.models.Curso;
import com.cursos.plataforma.models.DetalleCurso;
import com.cursos.plataforma.repositories.CursoRepository;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repositorio;

    public List<Curso> listarCursos() {
        return repositorio.findAll();
    }

    public Curso guardarCurso(Curso curso) {
        return repositorio.save(curso);
    }

    public Curso obtenerCursoPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public void eliminarCurso(Integer id) {
        repositorio.deleteById(id);
    }

    public Curso actualizarCurso(Integer id, Curso curso) {
        Curso cursoExistente = repositorio.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setDuracion(curso.getDuracion());
            cursoExistente.setPrecio(curso.getPrecio());
            cursoExistente.setUrlImagen(curso.getUrlImagen());
            DetalleCurso detalleNuevo = curso.getDetalle();
            cursoExistente.setFechaInicio(curso.getFechaInicio());
            if (detalleNuevo != null) {
                if (curso.getDetalle() != null) {
                    curso.getDetalle().setDescripcion(detalleNuevo.getDescripcion());
                    curso.getDetalle().setTemario(detalleNuevo.getTemario());
                    curso.getDetalle().setRequisitos(detalleNuevo.getRequisitos());
                } else {
                    curso.setDetalle(detalleNuevo);
                }
            }
            return repositorio.save(cursoExistente);
        }
        return null;
    }

    public List<Curso> obtenerCursoConMayPrecio() {
        return repositorio.obtenerCursosConMayorPrecio();
    }

    public List<Curso> obtenerCursosOrdenados() {
        return repositorio.ordenarCursosPrecioAscendente();
    }
}
