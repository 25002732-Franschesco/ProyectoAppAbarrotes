package org.utl.ldsm406_puntoventa.views.modulo_producto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.ProductionQuantityLimits
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // Cabecera con ícono
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = colorResource(id = R.color.naranja_4).copy(alpha = 0.15f),
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.Inventory2,
                        contentDescription = null,
                        tint = colorResource(id = R.color.naranja_4)
                    )
                }
            }
            Column {
                Text(
                    text = if (productoEditar == null) "Nuevo Producto" else "Editar Producto",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.cafe_5)
                )
                Text(
                    text = "Completa los datos del artículo",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.cafe_4)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.ShoppingBag, contentDescription = null, tint = colorResource(R.color.naranja_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Description, contentDescription = null, tint = colorResource(R.color.naranja_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Precio") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.LocalOffer, contentDescription = null, tint = colorResource(R.color.naranja_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = existencia,
            onValueChange = { existencia = it },
            label = { Text("Existencia") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.ProductionQuantityLimits, contentDescription = null, tint = colorResource(R.color.naranja_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoría") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Category, contentDescription = null, tint = colorResource(R.color.naranja_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        if (error.isNotBlank()){
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = onCancelar,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = colorResource(id = R.color.cafe_4)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
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
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.naranja_4),
                    contentColor = colorResource(id = R.color.crema_fondo)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(if (productoEditar == null) "Guardar" else "Actualizar")
            }
        }
    }
}