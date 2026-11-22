package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
            onEliminar = {
                surtidorEditar?.let { surt ->
                    surtidorViewModel.eliminar(surt)
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
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = colorResource(id = R.color.verde_4).copy(alpha = 0.15f),
                    modifier = Modifier.size(44.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = Icons.Default.LocalShipping,
                            contentDescription = null,
                            tint = colorResource(id = R.color.verde_4)
                        )
                    }
                }
                Column {
                    Text(
                        text = stringResource(id = R.string.suppliers_title),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.cafe_5)
                    )
                    Text(
                        text = stringResource(id = R.string.suppliers_registered_count, surtidores.size),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.cafe_4)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(surtidores, key = { it.id }) { surtidor ->
                    SurtidorCard(
                        surtidor = surtidor,
                        onClick = {
                            surtidorEditar = surtidor
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