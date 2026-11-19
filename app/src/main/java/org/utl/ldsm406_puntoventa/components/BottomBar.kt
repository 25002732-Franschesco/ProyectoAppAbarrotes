package org.utl.ldsm406_puntoventa.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R

data class BottomItem(
    val title: Int,
    val icon: ImageVector
)

@Composable
fun BottonBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    onCerrarSesion: () -> Unit = {}
){
    val items = listOf(
        BottomItem(
            R.string.nav_home,
            Icons.Default.Home
        ),
        BottomItem(
            R.string.nav_register,
            Icons.Default.AppRegistration
        ),
        BottomItem(
            R.string.nav_products,
            Icons.Default.ShoppingCart
        ),
        BottomItem(
            R.string.nav_suppliers,
            Icons.Default.Factory
        ),
        BottomItem(
            R.string.nav_exit,
            Icons.AutoMirrored.Filled.ExitToApp
        )
    )

    Surface(
        modifier = Modifier
            .shadow(
                elevation = 16.dp,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                ambientColor = colorResource(id = R.color.naranja_5).copy(alpha = 0.1f),
                spotColor = colorResource(id = R.color.naranja_5).copy(alpha = 0.1f)
            ),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        color = colorResource(id = R.color.crema_fondo)
    ) {
        NavigationBar(
            containerColor = colorResource(id = R.color.crema_fondo),
            contentColor = colorResource(id = R.color.cafe_5),
            tonalElevation = 0.dp,
            modifier = Modifier.height(72.dp)
        ) {
            items.forEachIndexed { index, item ->
                val isSalir = index == items.size - 1
                val isSelected = selectedItem == index
                val title = stringResource(item.title)
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        if (isSalir) {
                            onCerrarSesion()
                        } else {
                            onItemSelected(index)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = title,
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    label = {
                        AnimatedVisibility(
                            visible = isSelected,
                            enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it }),
                            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it })
                        ) {
                            Text(
                                text = title,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    },
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = colorResource(id = R.color.crema_fondo),
                        selectedTextColor = colorResource(id = R.color.naranja_4),
                        indicatorColor = colorResource(id = R.color.naranja_4),
                        unselectedIconColor = colorResource(id = R.color.cafe_4),
                        unselectedTextColor = colorResource(id = R.color.cafe_4)
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewBottonBar(){
    BottonBar(selectedItem = 0, onItemSelected = {}, onCerrarSesion = {})
}