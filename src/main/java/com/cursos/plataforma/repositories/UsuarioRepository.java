package com.cursos.plataforma.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursos.plataforma.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByNombreUsuario(String nombreUsuario);
}
