package br.com.bdurantecdev.forum.repository

import br.com.bdurantecdev.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<Usuario, Long> {
}