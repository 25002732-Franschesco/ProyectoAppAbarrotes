package org.utl.ldsm406_puntoventa.data.surtidor

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SurtidoresDAO {

    @Insert
    suspend fun insertar(surtidor: Surtidor)

    @Update
    suspend fun actualizar(surtidor: Surtidor)

    @Delete
    suspend fun eliminar(surtidor: Surtidor)

    @Query("SELECT * FROM surtidores")
    fun obtenerSurtidores(): Flow<List<Surtidor>>
}