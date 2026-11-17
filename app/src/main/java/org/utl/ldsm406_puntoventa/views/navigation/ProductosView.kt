package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.utl.ldsm406_puntoventa.data.producto.Producto
import org.utl.ldsm406_puntoventa.data.producto.ProductoViewModel
import org.utl.ldsm406_puntoventa.views.modulo_producto.ProductoCard
import org.utl.ldsm406_puntoventa.views.modulo_producto.ProductoFormView

@Composable
fun ProductosView(productoViewModel: ProductoViewModel = viewModel()) {
    val productos by productoViewModel.productos.collectAsState()
    var productoEditar by remember { mutableStateOf<Producto?>(null) }

    if (productoEditar != null) {
        ProductoFormView(
            productoEditar = productoEditar,
            onGuardar = { productoActualizado ->
                productoViewModel.guardar(productoActualizado) {
                    productoEditar = null // Regresa a la lista al terminar de guardar
                }
            },
            onCancelar = {
                productoEditar = null // Regresa a la lista sin guardar cambios
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Catálogo de Productos", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(productos, key = { it.id }) { producto ->
                    ProductoCard(
                        producto = producto,
                        onClick = {
                            productoEditar = producto // Al darle clic a la card, activa la edición
                        }
                    )
                }
            }
        }
    }
}