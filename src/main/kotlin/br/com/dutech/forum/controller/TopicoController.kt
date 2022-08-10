package br.com.dutech.forum.controller

import br.com.dutech.forum.model.Curso
import br.com.dutech.forum.model.Topico
import br.com.dutech.forum.model.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
    fun listar(): List<Topico>{
        val topico = Topico(
            id = 123,
            titulo = "Dúvida no Kotlin",
            mensagem = "Gostaria de tirar uma dúvida sobre Kotlin... bla bla bla",
            curso = Curso(
                id = 1,
                nome = "Construindo uma API Rest com Kotlin e Spring",
                categoria = "Backend"
            ),
            autor = Usuario(
                id = 1,
                nome = "Bruno",
                email = "bruno@gmail.com"
            )
        )

        return Arrays.asList(topico, topico, topico, topico)
    }

}