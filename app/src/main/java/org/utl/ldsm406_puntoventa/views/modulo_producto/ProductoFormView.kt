package org.utl.ldsm406_puntoventa.views.modulo_producto

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
import org.utl.ldsm406_puntoventa.data.producto.Producto

private data class CategoriaOpcion(
    val nombre: String,
    val icono: ImageVector
)

private val categoriasDisponibles = listOf(
    CategoriaOpcion("Bebidas", Icons.Default.LocalDrink),
    CategoriaOpcion("Botanas y Dulces", Icons.Default.Cookie),
    CategoriaOpcion("Lácteos", Icons.Default.EggAlt),
    CategoriaOpcion("Abarrotes", Icons.Default.Inventory2),
    CategoriaOpcion("Panadería", Icons.Default.BakeryDining),
    CategoriaOpcion("Frutas y Verduras", Icons.Default.Eco),
    CategoriaOpcion("Carnes y Embutidos", Icons.Default.SetMeal),
    CategoriaOpcion("Limpieza", Icons.Default.CleaningServices),
    CategoriaOpcion("Cuidado Personal", Icons.Default.Sanitizer),
    CategoriaOpcion("Congelados", Icons.Default.AcUnit),
    CategoriaOpcion("Mascotas", Icons.Default.Pets),
    CategoriaOpcion("Varios", Icons.Default.Category)
)

private val montosRapidos = listOf(5.0, 10.0, 15.0, 20.0, 25.0, 50.0)

private fun filtrarPrecioDecimal(input: String): String {
    val limpio = input.replace(',', '.')
    val sb = StringBuilder()
    var puntoUsado = false
    for (c in limpio) {
        when {
            c.isDigit() -> sb.append(c)
            c == '.' && !puntoUsado -> {
                sb.append(c)
                puntoUsado = true
            }
        }
    }
    val resultado = sb.toString()
    val partes = resultado.split('.')
    return if (partes.size == 2 && partes[1].length > 2) {
        "${partes[0]}.${partes[1].take(2)}"
    } else {
        resultado
    }
}

@Composable
fun ProductoFormView(
    productoEditar: Producto? = null,
    onGuardar: (Producto) -> Unit,
    onEliminar: () -> Unit = {},
    onCancelar: () -> Unit
){
    var nombre by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.nombre ?: "") }
    var descripcion by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.descripcion ?: "") }
    var precio by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.precio?.toString() ?: "") }
    var existencia by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.existencia?.toString() ?: "") }
    var categoria by rememberSaveable(productoEditar) { mutableStateOf(productoEditar?.categoria ?: "") }
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
                        text = stringResource(
                            id = if (productoEditar == null) {
                                R.string.product_form_new_title
                            } else {
                                R.string.product_form_edit_title
                            },
                        ),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.cafe_5)
                    )
                    Text(
                        text = stringResource(id = R.string.product_form_subtitle),
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
            leadingIcon = { Icon(Icons.Default.ShoppingBag, null, tint = colorResource(R.color.naranja_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text(stringResource(id = R.string.field_description)) },
            leadingIcon = { Icon(Icons.Default.Description, null, tint = colorResource(R.color.naranja_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
                unfocusedLabelColor = colorResource(R.color.cafe_4)
            )
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = filtrarPrecioDecimal(it) },
                label = { Text(stringResource(id = R.string.field_price)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                leadingIcon = { Icon(Icons.Default.LocalOffer, null, tint = colorResource(R.color.naranja_4)) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(R.color.naranja_4),
                    unfocusedBorderColor = colorResource(R.color.crema_3),
                    focusedLabelColor = colorResource(R.color.naranja_4),
                    unfocusedLabelColor = colorResource(R.color.cafe_4)
                )
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 2.dp)
            ) {
                items(montosRapidos) { monto ->
                    Surface(
                        onClick = {
                            val actual = precio.toDoubleOrNull() ?: 0.0
                            val suma = actual + monto
                            precio = if (suma % 1.0 == 0.0) {
                                suma.toInt().toString()
                            } else {
                                "%.2f".format(suma)
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        color = colorResource(id = R.color.crema_fondo),
                        border = BorderStroke(1.dp, colorResource(id = R.color.crema_3))
                    ) {
                        Text(
                            text = "+$${monto.toInt()}",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.naranja_4),
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            value = existencia,
            onValueChange = { existencia = it.filter { c -> c.isDigit() } },
            label = { Text(stringResource(id = R.string.field_stock)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            leadingIcon = { Icon(Icons.Default.ProductionQuantityLimits, null, tint = colorResource(R.color.naranja_4)) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.naranja_4),
                unfocusedBorderColor = colorResource(R.color.crema_3),
                focusedLabelColor = colorResource(R.color.naranja_4),
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
                    tint = colorResource(R.color.naranja_4),
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
                items(categoriasDisponibles, key = { it.nombre }) { item ->
                    val seleccionada = categoria.equals(item.nombre, ignoreCase = true)
                    val naranja = colorResource(R.color.naranja_4)

                    Surface(
                        onClick = { categoria = item.nombre },
                        shape = RoundedCornerShape(12.dp),
                        color = if (seleccionada) naranja else colorResource(R.color.crema_fondo),
                        border = BorderStroke(
                            width = 1.dp,
                            color = if (seleccionada) naranja else colorResource(R.color.crema_3)
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
                                tint = if (seleccionada) Color.White else naranja,
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
            if (productoEditar != null) {
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
                    val precioDouble = precio.toDoubleOrNull()
                    val existenciaInt = existencia.toIntOrNull()
                    val validationError = when {
                        nombre.isBlank() -> R.string.error_product_name_required
                        descripcion.isBlank() -> R.string.error_product_description_required
                        precioDouble == null -> R.string.error_product_price_invalid
                        existenciaInt == null -> R.string.error_product_stock_invalid
                        categoria.isBlank() -> R.string.error_product_category_required
                        else -> null
                    }
                    errorResId = validationError
                    if (validationError == null) {
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
                Text(text = stringResource(
                    id = if (productoEditar == null) {
                        R.string.action_save
                    } else {
                        R.string.action_update
                    }
                ), fontWeight = FontWeight.Bold)
            }
        }
    }
}