package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
            onCancelar = {
                mostrarFormSurtidor = false
                surtidorEditar = null
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.crema_1))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Módulo de Productos",
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
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text("Agregar Producto")
                }

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
                            }
                        )
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = 4.dp),
                color = colorResource(id = R.color.crema_3)
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Módulo de Surtidores",
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
                        contentColor = colorResource(id = R.color.white)
                    ),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                ) {
                    Text("Agregar Surtidor")
                }

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
                            }
                        )
                    }
                }
            }
        }
    }
}