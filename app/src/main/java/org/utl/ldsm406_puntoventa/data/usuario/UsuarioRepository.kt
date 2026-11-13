package org.utl.ldsm406_puntoventa.data.usuario

import kotlinx.coroutines.flow.Flow

class UsuarioRepository (
    private val usuariosDAO: UsuariosDAO
){
    suspend fun insertar(usuario: Usuario){
        return usuariosDAO.insertar(usuario)
    }
}