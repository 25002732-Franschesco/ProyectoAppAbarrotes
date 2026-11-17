package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.producto.Producto

@Composable
fun ProductoCard(
    producto: Producto,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.crema_2)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.cafe_5)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Categoría: ${producto.categoria}",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.cafe_4)
            )
            Text(
                text = "Precio: $${producto.precio} | Stock: ${producto.existencia}",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(id = R.color.verde_4)
            )
        }
    }
}