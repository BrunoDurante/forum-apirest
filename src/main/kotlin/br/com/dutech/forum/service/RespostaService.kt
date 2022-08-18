package br.com.dutech.forum.service

import br.com.dutech.forum.dto.NovaRespostaForm
import br.com.dutech.forum.mapper.RespostaFormMapper
import br.com.dutech.forum.model.Resposta
import org.springframework.stereotype.Service

@Service
class RespostaService(
    private var respostas: List<Resposta> = ArrayList(),
    private val respostaFormMapper: RespostaFormMapper,
    private val topicoService: TopicoService
) {

    fun cadastrar(form: NovaRespostaForm, idTopico: Long) {
        //Faz a transformação do form em model
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.buscarPorId(idTopico)

        //Adiciona a resposta na lista de respostas
        respostas = respostas.plus(resposta)
    }

}
