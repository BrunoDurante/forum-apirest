package br.com.dutech.forum.service

import br.com.dutech.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {

    init {
        val usuario1 = Usuario(
            id = 1,
            nome = "Bruno",
            email = "bruno@gmail.com"
        )

        val usuario2 = Usuario(
            id = 2,
            nome = "João",
            email = "joao@gmail.com"
        )

        usuarios = Arrays.asList(usuario1, usuario2)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter { usuario ->
            usuario.id == id
        }.findFirst().get()
    }
}