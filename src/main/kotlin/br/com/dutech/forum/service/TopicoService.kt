package br.com.dutech.forum.service

import br.com.dutech.forum.model.Curso
import br.com.dutech.forum.model.Topico
import br.com.dutech.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico1 = Topico(
            id = 1,
            titulo = "Dúvida no Kotlin - Tópico 1",
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

        val topico2 = Topico(
            id = 2,
            titulo = "Dúvida no Kotlin - Tópico 2",
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

        val topico3 = Topico(
            id = 3,
            titulo = "Dúvida no Kotlin - Tópico 3",
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
        topicos = Arrays.asList(topico1, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t ->
            t.id == id
        }.findFirst().get()
    }
}