package org.utl.ldsm406_puntoventa.views.modeulo_surtidor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
                color = colorResource(id = R.color.verde_4).copy(alpha = 0.15f),
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Default.LocalShipping,
                        contentDescription = null,
                        tint = colorResource(id = R.color.verde_4)
                    )
                }
            }
            Column {
                Text(
                    text = if (surtidorEditar == null) "Nuevo Surtidor" else "Editar Surtidor",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.cafe_5)
                )
                Text(
                    text = "Completa los datos del proveedor",
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
                Icon(imageVector = Icons.Default.Business, contentDescription = null, tint = colorResource(R.color.verde_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
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
                Icon(imageVector = Icons.Default.Description, contentDescription = null, tint = colorResource(R.color.verde_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text("Ubicación") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = colorResource(R.color.verde_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4),
                focusedTextColor = colorResource(R.color.cafe_5),
                unfocusedTextColor = colorResource(R.color.cafe_5)
            )
        )

        OutlinedTextField(
            value = numerotelefonico,
            onValueChange = { numerotelefonico = it },
            label = { Text("Número Telefónico") },
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Phone, contentDescription = null, tint = colorResource(R.color.verde_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
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
                Icon(imageVector = Icons.Default.Category, contentDescription = null, tint = colorResource(R.color.verde_4))
            },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
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
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.verde_4),
                    contentColor = colorResource(id = R.color.crema_fondo)
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text(if (surtidorEditar == null) "Guardar" else "Actualizar")
            }
        }
    }
}