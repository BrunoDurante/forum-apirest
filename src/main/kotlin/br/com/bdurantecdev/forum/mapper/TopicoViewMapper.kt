package br.com.bdurantecdev.forum.mapper

import br.com.bdurantecdev.forum.dto.TopicoView
import br.com.dutech.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, br.com.bdurantecdev.forum.dto.TopicoView> {

    override fun map(t: Topico): br.com.bdurantecdev.forum.dto.TopicoView {
        return br.com.bdurantecdev.forum.dto.TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }

}