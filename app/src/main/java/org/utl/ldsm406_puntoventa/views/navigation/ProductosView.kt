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
import org.utl.ldsm406_puntoventa.views.modulo_producto.ProductoFormView

@Composable
fun ProductosView(productoViewModel: ProductoViewModel = viewModel()) {
    val productos by productoViewModel.productos.collectAsState()
    var productoEditar by remember { mutableStateOf<Producto?>(null) }

    if (productoEditar != null) {
        ProductoFormView(
            productoEditar = productoEditar,
            onGuardar = { productoActualizado ->
                productoViewModel.guardar(productoActualizado) { productoEditar = null }
            },
            onCancelar = { productoEditar = null }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.crema_1))
                .padding(16.dp)
        ) {
            Text(
                text = "Catálogo de Productos",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.naranja_4)
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(productos, key = { it.id }) { producto ->
                    ProductoCard(
                        producto = producto,
                        onClick = { productoEditar = producto }
                    )
                }
            }
        }
    }
}