package br.com.dutech.forum.controller

import br.com.dutech.forum.dto.NovaRespostaForm
import br.com.dutech.forum.model.Resposta
import br.com.dutech.forum.service.RespostaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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