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
import org.utl.ldsm406_puntoventa.views.navigation.ProductoCard
import org.utl.ldsm406_puntoventa.views.navigation.ProductosYSurtidoresView
import org.utl.ldsm406_puntoventa.views.navigation.ProductosYSurtidoresView

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
                0 -> InicioView()
                1 -> ProductosYSurtidoresView()
                2 -> ProductoView()
                3 -> Surtido
            }
        }


    }
}

@Composable
@Preview
fun PreviewHomeView(){
    HomeView()
}