package br.com.bdurantecdev.forum.controller

import br.com.bdurantecdev.forum.dto.TopicoView
import br.com.bdurantecdev.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
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
    fun cadastrar(@RequestBody @Valid form: br.com.bdurantecdev.forum.dto.NovoTopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<br.com.bdurantecdev.forum.dto.TopicoView> {
        val topico = service.cadastrar(form)
        val uri = uriBuilder.path("/topicos/${topico.id}").build().toUri()
        return ResponseEntity.created(uri).body(topico)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: br.com.bdurantecdev.forum.dto.AtualizaTopicoDTO): ResponseEntity<br.com.bdurantecdev.forum.dto.TopicoView> {
        val topicoView = service.atualizar(dto)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long){
        service.deletar(id)
    }

}