package org.utl.ldsm406_puntoventa.data.surtidor

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surtidores")
data class Surtidor (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val ubicacion: String,
    val numerotelefonico: String,
    val categoria: String
)