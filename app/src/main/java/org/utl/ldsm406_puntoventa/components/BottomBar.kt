package org.utl.ldsm406_puntoventa.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import org.utl.ldsm406_puntoventa.R

data class BottomItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun BottonBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
){
    val items = listOf(
        BottomItem(
            "Inicio",
            Icons.Default.Home
        ),
        BottomItem(
            "Registrar",
            Icons.Default.AppRegistration
        ),
        BottomItem(
            "Productos",
            Icons.Default.ShoppingCart
        ),
        BottomItem(
            "Surtidores",
            Icons.Default.Factory
        )
    )

    NavigationBar(
        containerColor = colorResource(id = R.color.crema_2),
        contentColor = colorResource(id = R.color.cafe_5)
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    onItemSelected(index)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = R.color.crema_fondo),
                    selectedTextColor = colorResource(id = R.color.naranja_4),
                    indicatorColor = colorResource(id = R.color.naranja_3),
                    unselectedIconColor = colorResource(id = R.color.cafe_4),
                    unselectedTextColor = colorResource(id = R.color.cafe_4)
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottonBar(){
    BottonBar(selectedItem = 0, onItemSelected = {})
}