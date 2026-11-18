package org.utl.ldsm406_puntoventa.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.utl.ldsm406_puntoventa.components.BottonBar
import org.utl.ldsm406_puntoventa.views.navigation.InicioView
import org.utl.ldsm406_puntoventa.views.navigation.ProductosView
import org.utl.ldsm406_puntoventa.views.navigation.ProductosYSurtidoresView
import org.utl.ldsm406_puntoventa.views.navigation.SurtidoresView

@Composable
fun HomeView(
    onCerrarSesion: () -> Unit // <-- Recibe la acción de cerrar sesión
){
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {},
        bottomBar = {
            BottonBar(
                selectedItem = selectedItem,
                onItemSelected = { index ->
                    selectedItem = index
                },
                onCerrarSesion = onCerrarSesion
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            when (selectedItem) {
                0 -> InicioView(onItemSelected = { nuevoIndice -> selectedItem = nuevoIndice })
                1 -> ProductosYSurtidoresView()
                2 -> ProductosView()
                3 -> SurtidoresView()
            }
        }
    }
}

@Composable
@Preview
fun PreviewHomeView(){
    HomeView(onCerrarSesion = {})
}