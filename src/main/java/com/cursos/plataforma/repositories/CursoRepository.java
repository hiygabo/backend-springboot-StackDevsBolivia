package com.cursos.plataforma.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cursos.plataforma.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    //MOSTRAR LOS CURSOS CON MAYOR PRECIO
    @Query(value="SELECT * FROM cursos WHERE precio_curso = (SELECT MAX(precio_curso) FROM cursos )", nativeQuery=true)
    public List<Curso> obtenerCursosConMayorPrecio();

    //ORDENAR LOS CURSOS POR PRECIO ASCENDETE
    @Query(value="SELECT * FROM cursos ORDER BY precio_curso ASC", nativeQuery=true)
    public List<Curso> ordenarCursosPrecioAscendente();
    //ORDENAR LOS CURSOS POR PRECIO DESCENDENTE
    @Query(value="SELECT * FROM cursos ORDER BY precio_curso DESC", nativeQuery=true)
    public List<Curso> ordenarCursosPrecioDescendente();
}
