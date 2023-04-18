package br.com.bdurantecdev.forum.service

import br.com.bdurantecdev.forum.model.Curso
import br.com.bdurantecdev.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(
    private val cursoRepository: CursoRepository
) {

    fun buscarPorId(id: Long): Curso {
        return cursoRepository.getReferenceById(id)
    }

}