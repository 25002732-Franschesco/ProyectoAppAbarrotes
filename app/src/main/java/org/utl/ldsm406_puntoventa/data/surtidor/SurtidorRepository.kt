package org.utl.ldsm406_puntoventa.data.surtidor

import kotlinx.coroutines.flow.Flow

class SurtidorRepository(
    private val surtidoresDAO: SurtidoresDAO
) {
    val obtenerSurtidores: Flow<List<Surtidor>> = surtidoresDAO.obtenerSurtidores()

    suspend fun insertar(surtidor: Surtidor) {
        surtidoresDAO.insertar(surtidor)
    }

    suspend fun actualizar(surtidor: Surtidor) {
        surtidoresDAO.actualizar(surtidor)
    }

    suspend fun eliminar(surtidor: Surtidor) {
        surtidoresDAO.eliminar(surtidor)
    }
}