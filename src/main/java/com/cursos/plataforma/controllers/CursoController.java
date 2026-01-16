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
import com.cursos.plataforma.services.CursoService;
@CrossOrigin(origins="*", allowedHeaders="*")
@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService servicio;


    @GetMapping
    public List<Curso> listarCursos(){
        return servicio.listarCursos();
    }

    @DeleteMapping ("/{id}")
    public void eliminarCurso(@PathVariable Integer id){
        servicio.eliminarCurso(id);
    }

    @PostMapping
    public Curso guardarCurso (@RequestBody Curso curso){
        return servicio.guardarCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable Integer id) {
        return servicio.obtenerCursoPorId(id);
    }

    @PutMapping ("/{id}")

    public Curso actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso){
        return servicio.actualizarCurso(id, curso);
    }

    @GetMapping("/obtenerCursoMayor")

    public List<Curso> obtenerCursoConMayPrecio(){
        return servicio.obtenerCursoConMayPrecio();
    }

    @GetMapping("/holaMundo")
    public String holaMundo(){
        return "Hola Mundo, spring boot acaba de nacer";
    }

    @GetMapping("/cursosOrdenados")
    public List<Curso> obtenerCursosOrdenados(){
        return servicio.obtenerCursosOrdenados();
    }



}
