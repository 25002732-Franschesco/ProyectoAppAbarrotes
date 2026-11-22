package org.utl.ldsm406_puntoventa.views.modeulo_surtidor

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

@Composable
fun SurtidorFormView(
    surtidorEditar: Surtidor? = null,
    onGuardar: (Surtidor) -> Unit,
    onEliminar: () -> Unit = {},
    onCancelar: () -> Unit
){
    var nombre by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.nombre ?: "") }
    var descripcion by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.descripcion ?: "") }
    var ubicacion by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.ubicacion ?: "") }
    var numerotelefonico by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.numerotelefonico ?: "") }
    var categoria by rememberSaveable(surtidorEditar) { mutableStateOf(surtidorEditar?.categoria ?: "") }
    var errorResId by rememberSaveable { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.crema_1))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
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
                        text = stringResource(
                            id = if (surtidorEditar == null) {
                                R.string.supplier_form_new_title
                            } else {
                                R.string.supplier_form_edit_title
                            }
                        ),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.cafe_5)
                    )
                    Text(
                        text = stringResource(id = R.string.supplier_form_subtitle),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.cafe_4)
                    )
                }
            }

            IconButton(
                onClick = onCancelar,
                modifier = Modifier
                    .size(40.dp)
                    .background(colorResource(id = R.color.crema_3).copy(alpha = 0.5f), shape = RoundedCornerShape(10.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(id = R.string.action_cancel),
                    tint = colorResource(id = R.color.cafe_5)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(stringResource(id = R.string.field_name)) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Business, contentDescription = null, tint = colorResource(R.color.verde_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text(stringResource(id = R.string.field_description)) },
            leadingIcon = { Icon(imageVector = Icons.Default.Description, contentDescription = null, tint = colorResource(R.color.verde_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text(stringResource(id = R.string.field_location)) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.LocationOn, contentDescription = null, tint = colorResource(R.color.verde_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        OutlinedTextField(
            value = numerotelefonico,
            onValueChange = { numerotelefonico = it },
            label = { Text(stringResource(id = R.string.field_phone)) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Phone, contentDescription = null, tint = colorResource(R.color.verde_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text(stringResource(id = R.string.field_category)) },
            singleLine = true,
            leadingIcon = { Icon(imageVector = Icons.Default.Category, contentDescription = null, tint = colorResource(R.color.verde_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.verde_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.verde_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        errorResId?.let { resId ->
            Text(
                text = stringResource(id = resId),
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (surtidorEditar != null) {
                Button(
                    onClick = onEliminar,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error,
                        contentColor = colorResource(id = R.color.crema_fondo)
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = stringResource(id = R.string.action_delete))
                }
            }

            Button(
                onClick = {
                    val validationError = when {
                        nombre.isBlank() -> R.string.error_supplier_name_required
                        descripcion.isBlank() -> R.string.error_supplier_description_required
                        ubicacion.isBlank() -> R.string.error_supplier_location_required
                        numerotelefonico.isBlank() -> R.string.error_supplier_phone_required
                        categoria.isBlank() -> R.string.error_supplier_category_required
                        else -> null
                    }
                    errorResId = validationError
                    if (validationError == null) {
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
                Text(text = stringResource(
                    id = if (surtidorEditar == null) {
                        R.string.action_save
                    } else {
                        R.string.action_update
                    }
                ), fontWeight = FontWeight.Bold)
            }
        }
    }
}