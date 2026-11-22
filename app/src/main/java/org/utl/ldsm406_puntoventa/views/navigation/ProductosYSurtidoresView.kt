package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.producto.Producto
import org.utl.ldsm406_puntoventa.data.producto.ProductoViewModel
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor
import org.utl.ldsm406_puntoventa.data.surtidor.SurtidorViewModel
import org.utl.ldsm406_puntoventa.views.modulo_producto.ProductoFormView
import org.utl.ldsm406_puntoventa.views.modeulo_surtidor.SurtidorFormView

@Composable
fun ProductosYSurtidoresView(
    productoViewModel: ProductoViewModel = viewModel(),
    surtidorViewModel: SurtidorViewModel = viewModel()
) {
    val productos by productoViewModel.productos.collectAsState()
    val surtidores by surtidorViewModel.listaSurtidores.collectAsState()
    var mostrarFormProducto by remember { mutableStateOf(false) }
    var productoEditar by remember { mutableStateOf<Producto?>(null) }
    var mostrarFormSurtidor by remember { mutableStateOf(false) }
    var surtidorEditar by remember { mutableStateOf<Surtidor?>(null) }

    if (mostrarFormProducto) {
        ProductoFormView(
            productoEditar = productoEditar,
            onGuardar = { producto ->
                productoViewModel.guardar(producto) {
                    mostrarFormProducto = false
                    productoEditar = null
                }
            },
            onEliminar = {
                productoEditar?.let { prod ->
                    productoViewModel.eliminar(prod)
                    mostrarFormProducto = false
                    productoEditar = null
                }
            },
            onCancelar = {
                mostrarFormProducto = false
                productoEditar = null
            }
        )
    } else if (mostrarFormSurtidor) {
        SurtidorFormView(
            surtidorEditar = surtidorEditar,
            onGuardar = { surtidor ->
                surtidorViewModel.guardar(surtidor) {
                    mostrarFormSurtidor = false
                    surtidorEditar = null
                }
            },
            onEliminar = {
                surtidorEditar?.let { surt ->
                    surtidorViewModel.eliminar(surt)
                    mostrarFormSurtidor = false
                    surtidorEditar = null
                }
            },
            onCancelar = {
                mostrarFormSurtidor = false
                surtidorEditar = null
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.crema_1),
                            colorResource(id = R.color.crema_3)
                        )
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
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
                            imageVector = Icons.Default.PlaylistAdd,
                            contentDescription = null,
                            tint = colorResource(id = R.color.naranja_4)
                        )
                    }
                }
                Column {
                    Text(
                        text = stringResource(id = R.string.register_panel_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.cafe_5)
                    )
                    Text(
                        text = stringResource(id = R.string.register_panel_subtitle),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.cafe_4)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.crema_2)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.products_section_count, productos.size),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.cafe_5)
                        )
                        Button(
                            onClick = {
                                productoEditar = null
                                mostrarFormProducto = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.naranja_4),
                                contentColor = colorResource(id = R.color.crema_fondo)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = stringResource(id = R.string.action_add))
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(items = productos, key = { it.id }) { producto ->
                            ProductoCard(
                                producto = producto,
                                onClick = {
                                    productoEditar = producto
                                    mostrarFormProducto = true
                                },
                                onDelete = {
                                    productoViewModel.eliminar(producto)
                                }
                            )
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.crema_2)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(id = R.string.suppliers_section_count, surtidores.size),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = colorResource(id = R.color.cafe_5)
                        )
                        Button(
                            onClick = {
                                surtidorEditar = null
                                mostrarFormSurtidor = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.verde_4),
                                contentColor = colorResource(id = R.color.crema_fondo)
                            ),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = stringResource(id = R.string.action_add))
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(items = surtidores, key = { it.id }) { surtidor ->
                            SurtidorCard(
                                surtidor = surtidor,
                                onClick = {
                                    surtidorEditar = surtidor
                                    mostrarFormSurtidor = true
                                },
                                onDelete = {
                                    surtidorViewModel.eliminar(surtidor)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}