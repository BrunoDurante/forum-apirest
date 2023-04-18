package br.com.bdurantecdev.forum.mapper

import br.com.bdurantecdev.forum.dto.NovaRespostaForm
import br.com.bdurantecdev.forum.model.Resposta
import br.com.bdurantecdev.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService
) : Mapper<NovaRespostaForm, Resposta> {

    override fun map(t: NovaRespostaForm): Resposta {
        val usuario = usuarioService.buscarPorId(t.idAutor)
        return Resposta(
            mensagem = t.mensagem,
            autor = usuario,
            solucao = false
        )
    }

}