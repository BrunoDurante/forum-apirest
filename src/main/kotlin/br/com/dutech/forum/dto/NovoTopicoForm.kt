package br.com.dutech.forum.dto

data class NovoTopicoForm (
        val titulo: String,
        val mensagem: String,
        val idCurso: Long,
        val idAutor: Long
)