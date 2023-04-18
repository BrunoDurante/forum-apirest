package br.com.bdurantecdev.forum.repository

import br.com.bdurantecdev.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository: JpaRepository<Topico, Long> {
}