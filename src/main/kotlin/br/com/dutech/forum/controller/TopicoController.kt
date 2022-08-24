package br.com.dutech.forum.controller

import br.com.dutech.forum.dto.AtualizaTopicoDTO
import br.com.dutech.forum.dto.NovoTopicoForm
import br.com.dutech.forum.dto.TopicoView
import br.com.dutech.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: NovoTopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoView> {
        val topico = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topico.id}").build().toUri()
        return ResponseEntity.created(uri).body(topico)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizaTopicoDTO): ResponseEntity<TopicoView> {
        val topicoView = service.atualizar(dto)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}