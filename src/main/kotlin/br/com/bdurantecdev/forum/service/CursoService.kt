package br.com.bdurantecdev.forum.service

import br.com.bdurantecdev.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(var cursos: List<Curso>) {

    init {
        val curso1 = Curso(
            id = 1,
            nome = "API Rest com Kotlin e Spring Boot",
            categoria = "Backend"
        )

        val curso2 = Curso(
            id = 2,
            nome = "P.O.O com Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso1, curso2)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter { curso ->
            curso.id == id
        }.findFirst().get()
    }

}