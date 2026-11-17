package org.utl.ldsm406_puntoventa.views.modeulo_surtidor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

@Composable
fun SurtidorFormView(
    surtidorEditar: Surtidor? = null,
    onGuardar: (Surtidor) -> Unit,
    onCancelar: () -> Unit
){
    var nombre by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.nombre ?: "") }
    var descripcion by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.descripcion ?: "") }
    var ubicacion by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.ubicacion ?: "") }
    var numerotelefonico by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.numerotelefonico ?: "") }
    var categoria by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.categoria ?: "") }
    var error by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.crema_1))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = if (surtidorEditar == null) "Registro de surtidor" else "Editar surtidor",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.cafe_5)
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre: ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción: ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text("Ubicación: ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numerotelefonico,
            onValueChange = { numerotelefonico = it },
            label = { Text("Número Telefónico: ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría: ") },
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotBlank()){
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedButton(
                onClick = onCancelar,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = colorResource(id = R.color.cafe_4)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }

            Button(
                onClick = {
                    error = when {
                        nombre.isBlank() -> "Captura el nombre del surtidor"
                        descripcion.isBlank() -> "Captura la descripción del surtidor"
                        ubicacion.isBlank() -> "Captura la ubicación del surtidor"
                        numerotelefonico.isBlank() -> "Captura el número telefónico"
                        categoria.isBlank() -> "Captura la categoría del surtidor"
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.verde_4),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(if (surtidorEditar == null) "Guardar" else "Actualizar")
            }
        }
    }
}