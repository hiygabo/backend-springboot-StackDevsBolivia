package com.cursos.plataforma.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.plataforma.models.Curso;
import com.cursos.plataforma.models.DetalleCurso;
import com.cursos.plataforma.repositories.CursoRepository;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoRepository repositorio;


    @GetMapping
    public List<Curso> listarCursos(){
        return repositorio.findAll();
    }

    @DeleteMapping ("/{id}")
    public void eliminarCurso(@PathVariable Integer id){
        repositorio.deleteById(id);
    }

    @PostMapping
    public Curso guardarCurso (@RequestBody Curso curso){
        return repositorio.save(curso);
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @PutMapping ("/{id}")

    public Curso actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso){
        Curso cursoExistente = repositorio.findById(id).orElse(null);
        if(cursoExistente != null){
            cursoExistente.setNombre(curso.getNombre());
            cursoExistente.setDescripcion(curso.getDescripcion());
            cursoExistente.setDuracion(curso.getDuracion());
            cursoExistente.setPrecio(curso.getPrecio());
            cursoExistente.setUrlImagen(curso.getUrlImagen());
            DetalleCurso detalleNuevo = curso.getDetalle();
            cursoExistente.setFechaInicio(curso.getFechaInicio());
            if(detalleNuevo !=null){
                if(curso.getDetalle() !=null){
                    curso.getDetalle().setDescripcion(detalleNuevo.getDescripcion());
                    curso.getDetalle().setTemario(detalleNuevo.getTemario());
                    curso.getDetalle().setRequisitos(detalleNuevo.getRequisitos());
                }else{
                    curso.setDetalle(detalleNuevo);
                }
            }
            return repositorio.save(cursoExistente);
        }
        return null;
    }

    @GetMapping("/obtenerCursoMayor")

    public List<Curso> obtenerCursoConMayPrecio(){
        return repositorio.obtenerCursosConMayorPrecio();
    }

    @GetMapping("/holaMundo")
    public String holaMundo(){
        return "Hola Mundo, spring boot acaba de nacer";
    }

    @GetMapping("/cursosOrdenados")
    public List<Curso> obtenerCursosOrdenados(){
        return repositorio.ordenarCursosPrecioAscendente();
    }



}
