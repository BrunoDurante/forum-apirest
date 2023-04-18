package br.com.bdurantecdev.forum.service

import br.com.bdurantecdev.forum.dto.AtualizaTopicoDTO
import br.com.bdurantecdev.forum.dto.NovoTopicoForm
import br.com.bdurantecdev.forum.dto.TopicoView
import br.com.dutech.forum.exception.NotFoundException
import br.com.dutech.forum.mapper.TopicoFormMapper
import br.com.dutech.forum.mapper.TopicoViewMapper
import br.com.dutech.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper,
    private var notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<br.com.bdurantecdev.forum.dto.TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): br.com.bdurantecdev.forum.dto.TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: br.com.bdurantecdev.forum.dto.NovoTopicoForm): br.com.bdurantecdev.forum.dto.TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: br.com.bdurantecdev.forum.dto.AtualizaTopicoDTO): br.com.bdurantecdev.forum.dto.TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == dto.id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        val novoTopico = Topico(
            id = topico.id,
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            dataCriacao = topico.dataCriacao,
            curso = topico.curso,
            autor = topico.autor,
            status = topico.status,
            respostas = topico.respostas
        )

        topicos = topicos.minus(topico).plus(novoTopico)
        return topicoViewMapper.map(novoTopico)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter{
            t -> t.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        topicos = topicos.minus(topico)
    }
}