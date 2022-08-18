package br.com.dutech.forum.mapper

import br.com.dutech.forum.dto.NovaRespostaForm
import br.com.dutech.forum.model.Resposta
import br.com.dutech.forum.service.UsuarioService
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