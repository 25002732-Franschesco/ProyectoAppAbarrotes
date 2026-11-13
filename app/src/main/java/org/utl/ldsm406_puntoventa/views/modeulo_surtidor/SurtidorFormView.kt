package org.utl.ldsm406_puntoventa.views.modeulo_surtidor

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

@Composable
fun SurtidorFormView(
    surtidorEditar: Surtidor? = null,
    onGuardar: (Surtidor) -> Unit,
    onCancelar: () -> Unit
){
    var nombre by rememberSaveable() { mutableStateOf("") }
    var descripcion by rememberSaveable() { mutableStateOf("") }
    var ubicacion by rememberSaveable() { mutableStateOf("") }
    var numerotelefonico by rememberSaveable() { mutableStateOf("") }
    var categoria by rememberSaveable() { mutableStateOf("") }
    var error by rememberSaveable() { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Registro de surtidor")

        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {Text("Nombre: ")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = {descripcion = it},
            label = {Text("Descripcion: ")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ubicacion,
            onValueChange = {ubicacion = it},
            label = {Text("Ubicacion: ")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numerotelefonico,
            onValueChange = {numerotelefonico = it},
            label = {Text("Numero Telefonico: ")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = {categoria = it},
            label = {Text("Categoria: ")},
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotBlank()){
            Text(error)
        }

        Button(
            onClick = {
                error = when{
                    nombre.isBlank() -> "Captura el nombre del surtidor"
                    descripcion.isBlank() -> "Captura la descripcion del surtidor"
                    ubicacion.isBlank() -> "Captura la ubicacion del surtidor"
                    numerotelefonico.isBlank() -> "Captura el numero telefonico"
                    categoria.isBlank() -> "Captura la categoria del surtidor"
                    else -> ""
                }
                if (error.isBlank()){
                    onGuardar(
                        Surtidor(
                            id = surtidorEditar?.id ?: 0,
                            nombre = nombre.trim(),
                            descripcion = descripcion.trim(),
                            ubicacion = ubicacion.trim(),
                            numerotelefonico = numerotelefonico.trim(),
                            categoria = categoria.trim()
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}