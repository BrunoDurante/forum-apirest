package br.com.bdurantecdev.forum.dto

import javax.validation.constraints.NotEmpty

data class NovaRespostaForm(
    @field:NotEmpty
    val mensagem: String,
    val idAutor: Long
)
