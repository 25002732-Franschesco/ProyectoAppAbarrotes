package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor

@Composable
fun SurtidorCard(surtidor: Surtidor) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = surtidor.nombre, style = MaterialTheme.typography.titleSmall)
            Text(text = "Ubicación: ${surtidor.ubicacion}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Tel: ${surtidor.numerotelefonico}", style = MaterialTheme.typography.bodySmall)
        }
    }
}