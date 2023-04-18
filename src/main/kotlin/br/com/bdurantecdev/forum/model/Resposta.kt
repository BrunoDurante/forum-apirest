package br.com.bdurantecdev.forum.model

import br.com.bdurantecdev.forum.dto.TopicoView
import java.time.LocalDateTime

data class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: br.com.bdurantecdev.forum.dto.TopicoView? = null,
    val solucao: Boolean
)
