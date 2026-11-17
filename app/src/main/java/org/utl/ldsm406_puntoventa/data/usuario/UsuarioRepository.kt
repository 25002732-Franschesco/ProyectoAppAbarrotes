package org.utl.ldsm406_puntoventa.data.usuario

class UsuarioRepository(
    private val usuariosDAO: UsuariosDAO
) {
    suspend fun insertar(usuario: Usuario) {
        usuariosDAO.insertar(usuario)
    }

    suspend fun iniciarSesion(usuario: String, pass: String): Usuario? {
        return usuariosDAO.obtenerUsuario(usuario, pass)
    }

    suspend fun existeUsuario(usuario: String): Usuario? {
        return usuariosDAO.buscarPorUsuario(usuario)
    }
}