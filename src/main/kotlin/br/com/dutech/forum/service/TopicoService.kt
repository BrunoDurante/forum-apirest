package br.com.dutech.forum.service

import br.com.dutech.forum.dto.AtualizaTopicoDTO
import br.com.dutech.forum.dto.NovoTopicoForm
import br.com.dutech.forum.dto.TopicoView
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

    fun listar(): List<TopicoView> {
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizaTopicoDTO): TopicoView {
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