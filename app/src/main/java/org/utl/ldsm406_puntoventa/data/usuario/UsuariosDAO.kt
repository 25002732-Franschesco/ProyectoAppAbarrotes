package org.utl.ldsm406_puntoventa.data.usuario

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuariosDAO {
    @Insert
    suspend fun insertar(usuario: Usuario)

}