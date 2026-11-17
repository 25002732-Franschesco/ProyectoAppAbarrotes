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
import org.utl.ldsm406_puntoventa.data.surtidor.Surtidor
import org.utl.ldsm406_puntoventa.data.surtidor.SurtidorViewModel
import org.utl.ldsm406_puntoventa.views.modeulo_surtidor.SurtidorFormView

@Composable
fun SurtidoresView(surtidorViewModel: SurtidorViewModel = viewModel()) {
    val surtidores by surtidorViewModel.listaSurtidores.collectAsState()
    var surtidorEditar by remember { mutableStateOf<Surtidor?>(null) }

    if (surtidorEditar != null) {
        SurtidorFormView(
            surtidorEditar = surtidorEditar,
            onGuardar = { surtidorActualizado ->
                surtidorViewModel.guardar(surtidorActualizado) {
                    surtidorEditar = null
                }
            },
            onCancelar = {
                surtidorEditar = null
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.crema_1))
                .padding(16.dp)
        ) {
            Text(
                text = "Catálogo de Surtidores",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.verde_4)
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(surtidores, key = { it.id }) { surtidor ->
                    SurtidorCard(
                        surtidor = surtidor,
                        onClick = {
                            surtidorEditar = surtidor
                        }
                    )
                }
            }
        }
    }
}