package br.com.dutech.forum.service

import br.com.dutech.forum.dto.NovoTopicoForm
import br.com.dutech.forum.dto.TopicoView
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
    private var topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm){
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}