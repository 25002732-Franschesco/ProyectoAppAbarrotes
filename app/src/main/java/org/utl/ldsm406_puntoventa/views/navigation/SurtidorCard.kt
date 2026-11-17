package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

@Composable
fun SurtidorCard(
    surtidor: Surtidor,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.crema_2)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = surtidor.nombre,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.cafe_5)
            )
            Text(
                text = "Ubicación: ${surtidor.ubicacion}",
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.cafe_4)
            )
            Text(
                text = "Tel: ${surtidor.numerotelefonico}",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Medium,
                color = colorResource(id = R.color.naranja_4)
            )
        }
    }
}