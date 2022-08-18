package br.com.dutech.forum.model

import br.com.dutech.forum.dto.TopicoView
import java.time.LocalDateTime

data class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: TopicoView? = null,
    val solucao: Boolean
)
