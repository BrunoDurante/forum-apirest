package br.com.bdurantecdev.forum.mapper

import br.com.bdurantecdev.forum.dto.NovoTopicoForm
import br.com.bdurantecdev.forum.model.Topico
import br.com.bdurantecdev.forum.service.CursoService
import br.com.bdurantecdev.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private var cursoService: CursoService,
    private var usuarioService: UsuarioService
) : Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}