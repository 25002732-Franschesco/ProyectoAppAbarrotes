package org.utl.ldsm406_puntoventa.data.usuario

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDAO {
    @Insert
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE usuario = :nombreUsuario AND password = :contrasena LIMIT 1")
    suspend fun obtenerUsuario(nombreUsuario: String, contrasena: String): Usuario?

    @Query("SELECT * FROM usuarios WHERE usuario = :nombreUsuario LIMIT 1")
    suspend fun buscarPorUsuario(nombreUsuario: String): Usuario?
}