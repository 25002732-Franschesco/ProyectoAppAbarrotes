package org.utl.ldsm406_puntoventa.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.components.BottonBar
import org.utl.ldsm406_puntoventa.views.navigation.InicioView
import org.utl.ldsm406_puntoventa.views.navigation.ProductosView
import org.utl.ldsm406_puntoventa.views.navigation.ProductosYSurtidoresView
import org.utl.ldsm406_puntoventa.views.navigation.SurtidoresView

@Composable
fun HomeView(){
    var selectedItem by remember { mutableStateOf(0) }

    Scaffold(
        topBar =  {},
        bottomBar = {
            BottonBar(
                selectedItem = selectedItem,
                onItemSelected = {
                    selectedItem = it
                }
            )
        },
        floatingActionButton = {
            Button(onClick = {}, modifier = Modifier.size(78.dp),
                shape = CircleShape
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Agregar")
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
        ){

            when(selectedItem){
                0 -> InicioView()               // Botón 0: Inicio
                1 -> ProductosYSurtidoresView() // Botón 1: Registrar (Pantalla dividida 50/50)
                2 -> ProductosView()           // Botón 2: Productos (Lista completa)
                3 -> SurtidoresView()           // Botón 3: Surtidores (Lista completa)
            }
        }


    }
}

@Composable
@Preview
fun PreviewHomeView(){
    HomeView()
}