package org.utl.ldsm406_puntoventa.data.producto

import kotlinx.coroutines.flow.Flow

class ProductoRepository (
    private val productosDAO: ProductosDAO
){
    fun obtenerTodos(): Flow<List<Producto>> {
        return productosDAO.obtenerTodos()
    }

    suspend fun obtenerPorID(id: Int): Producto? {
        return productosDAO.obtenerPorID(id)
        // return obtenerPorID(id)
    }

    suspend fun insertar(producto: Producto){
        return productosDAO.insertar(producto)
    }

    suspend fun actualizar(producto: Producto){
        return productosDAO.actualizar(producto)
    }

    suspend fun eliminar(producto: Producto){
        productosDAO.eliminar(producto)
    }
}