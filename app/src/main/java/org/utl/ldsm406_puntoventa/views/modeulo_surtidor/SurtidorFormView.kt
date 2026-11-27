package org.utl.ldsm406_puntoventa.views.modeulo_surtidor

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

private data class CategoriaSurtidorOpcion(
    val nombre: String,
    val icono: ImageVector
)

private val categoriasSurtidores = listOf(
    CategoriaSurtidorOpcion("Refrescos y Bebidas", Icons.Default.LocalDrink),
    CategoriaSurtidorOpcion("Botanas y Frituras", Icons.Default.Cookie),
    CategoriaSurtidorOpcion("Lácteos y Refrigerados", Icons.Default.EggAlt),
    CategoriaSurtidorOpcion("Abarrotes al Mayoreo", Icons.Default.Inventory2),
    CategoriaSurtidorOpcion("Pan y Tortillería", Icons.Default.BakeryDining),
    CategoriaSurtidorOpcion("Carnicería y Embutidos", Icons.Default.SetMeal),
    CategoriaSurtidorOpcion("Frutas y Verduras", Icons.Default.Eco),
    CategoriaSurtidorOpcion("Limpieza y Químicos", Icons.Default.CleaningServices),
    CategoriaSurtidorOpcion("Higiene y Farmacia", Icons.Default.MedicalServices),
    CategoriaSurtidorOpcion("Hielo y Congelados", Icons.Default.AcUnit),
    CategoriaSurtidorOpcion("Alimento para Mascotas", Icons.Default.Pets),
    CategoriaSurtidorOpcion("Distribuidor General", Icons.Default.LocalShipping)
)

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
    var numerotelefonico by rememberSaveable(surtidorEditar) {
        mutableStateOf(surtidorEditar?.numerotelefonico?.filter { it.isDigit() }?.take(10) ?: "")
    }
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
            onValueChange = { nuevo ->
                numerotelefonico = nuevo.filter { it.isDigit() }.take(10)
            },
            label = { Text(stringResource(id = R.string.field_phone)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Category,
                    contentDescription = null,
                    tint = colorResource(R.color.verde_4),
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = stringResource(id = R.string.field_category),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.cafe_5)
                )
            }

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 2.dp)
            ) {
                items(categoriasSurtidores, key = { it.nombre }) { item ->
                    val seleccionada = categoria.equals(item.nombre, ignoreCase = true)
                    val verde = colorResource(R.color.verde_4)

                    Surface(
                        onClick = { categoria = item.nombre },
                        shape = RoundedCornerShape(12.dp),
                        color = if (seleccionada) verde else colorResource(R.color.crema_fondo),
                        border = BorderStroke(
                            width = 1.dp,
                            color = if (seleccionada) verde else colorResource(R.color.crema_3)
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            Icon(
                                imageVector = item.icono,
                                contentDescription = item.nombre,
                                tint = if (seleccionada) Color.White else verde,
                                modifier = Modifier.size(18.dp)
                            )
                            Text(
                                text = item.nombre,
                                fontSize = 13.sp,
                                fontWeight = if (seleccionada) FontWeight.Bold else FontWeight.Medium,
                                color = if (seleccionada) Color.White else colorResource(R.color.cafe_5)
                            )
                        }
                    }
                }
            }
        }

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