package br.com.bdurantecdev.forum.service

import br.com.bdurantecdev.forum.model.Usuario
import br.com.bdurantecdev.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
) {
    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.getReferenceById(id)
    }
}