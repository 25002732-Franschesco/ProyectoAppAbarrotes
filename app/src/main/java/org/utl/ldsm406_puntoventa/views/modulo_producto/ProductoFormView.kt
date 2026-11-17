package org.utl.ldsm406_puntoventa.views.modulo_producto

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
import org.utl.ldsm406_puntoventa.data.producto.Producto

@Composable
fun ProductoFormView(
    productoEditar: Producto? = null,
    onGuardar: (Producto) -> Unit,
    onCancelar: () -> Unit
){
    var nombre by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.nombre ?: "") }
    var descripcion by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.descripcion ?: "") }
    var precio by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.precio?.toString() ?: "") }
    var existencia by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.existencia?.toString() ?: "") }
    var categoria by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.categoria ?: "") }
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
            text = if (productoEditar == null) "Registro de producto" else "Editar producto",
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
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio: ") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = existencia,
            onValueChange = { existencia = it },
            label = { Text("Existencia: ") },
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
                    val precioDouble = precio.toDoubleOrNull()
                    val existenciaInt = existencia.toIntOrNull()
                    error = when {
                        nombre.isBlank() -> "Captura el nombre del producto"
                        descripcion.isBlank() -> "Captura la descripción del producto"
                        precioDouble == null -> "Captura el precio del producto"
                        existenciaInt == null -> "Captura la cantidad disponible"
                        categoria.isBlank() -> "Captura la categoría del producto"
                        else -> ""
                    }
                    if (error.isBlank()){
                        onGuardar(
                            Producto(
                                id = productoEditar?.id ?: 0,
                                nombre = nombre.trim(),
                                descripcion = descripcion.trim(),
                                precio = precioDouble!!,
                                existencia = existenciaInt!!,
                                categoria = categoria.trim()
                            )
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.naranja_4),
                    contentColor = colorResource(id = R.color.white)
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text(if (productoEditar == null) "Guardar" else "Actualizar")
            }
        }
    }
}