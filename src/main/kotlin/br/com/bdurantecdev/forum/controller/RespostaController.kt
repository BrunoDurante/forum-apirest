package br.com.bdurantecdev.forum.controller

import br.com.bdurantecdev.forum.dto.NovaRespostaForm
import br.com.bdurantecdev.forum.service.RespostaService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/respostas")
class RespostaController(
    private val service: RespostaService
) {

    @PostMapping("/{id}")
    fun cadastrar(@PathVariable id: Long, @RequestBody @Valid form: NovaRespostaForm) {
        service.cadastrar(form, id)
    }

}