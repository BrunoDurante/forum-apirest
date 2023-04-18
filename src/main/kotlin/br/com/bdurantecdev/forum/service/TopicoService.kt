package br.com.bdurantecdev.forum.service

import br.com.bdurantecdev.forum.dto.AtualizaTopicoDTO
import br.com.bdurantecdev.forum.dto.NovoTopicoForm
import br.com.bdurantecdev.forum.dto.TopicoView
import br.com.bdurantecdev.forum.exception.NotFoundException
import br.com.bdurantecdev.forum.mapper.TopicoFormMapper
import br.com.bdurantecdev.forum.mapper.TopicoViewMapper
import br.com.bdurantecdev.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper,
    private var notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicoRepository.findAll().stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepository.getReferenceById(id)
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(dto: AtualizaTopicoDTO): TopicoView {
        val topico = topicoRepository.findById(dto.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        topico.also {
            it.mensagem = dto.mensagem
            it.titulo = dto.titulo
        }

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }
}