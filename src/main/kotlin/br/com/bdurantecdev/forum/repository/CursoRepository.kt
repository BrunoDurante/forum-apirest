package br.com.bdurantecdev.forum.repository

import br.com.bdurantecdev.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository:JpaRepository<Curso, Long> {
}