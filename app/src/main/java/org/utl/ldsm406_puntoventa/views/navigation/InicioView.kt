package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R

@Composable
fun InicioView(
    onItemSelected: (Int) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.crema_1))
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.naranja_4)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Text(
                    text = "¡Bienvenido de nuevo!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sistema de Punto de Venta - Tienda de Abarrotes",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colorResource(id = R.color.crema_2)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Accesos Rápidos",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.cafe_5)
        )

        MenuCard(
            titulo = "Catálogo de Productos",
            descripcion = "Consulta precios, stock y gestiona los productos.",
            icono = Icons.Default.ShoppingCart,
            containerColor = colorResource(id = R.color.crema_2),
            contentColor = colorResource(id = R.color.naranja_4),
            onClick = { onItemSelected(2) }
        )

        MenuCard(
            titulo = "Catálogo de Surtidores",
            descripcion = "Administra proveedores y surtidores registrados.",
            icono = Icons.Default.Factory,
            containerColor = colorResource(id = R.color.crema_2),
            contentColor = colorResource(id = R.color.verde_4),
            onClick = { onItemSelected(3) }
        )

        MenuCard(
            titulo = "Registrar Nuevos",
            descripcion = "Da de alta nuevos productos o surtidores al sistema.",
            icono = Icons.Default.AppRegistration,
            containerColor = colorResource(id = R.color.crema_2),
            contentColor = colorResource(id = R.color.cafe_5),
            onClick = { onItemSelected(1) }
        )
    }
}

@Composable
fun MenuCard(
    titulo: String,
    descripcion: String,
    icono: ImageVector,
    containerColor: androidx.compose.ui.graphics.Color,
    contentColor: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = containerColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = contentColor.copy(alpha = 0.15f),
                modifier = Modifier.size(48.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icono,
                        contentDescription = null,
                        tint = contentColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.cafe_5)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.cafe_4)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewInicio() {
    InicioView()
}