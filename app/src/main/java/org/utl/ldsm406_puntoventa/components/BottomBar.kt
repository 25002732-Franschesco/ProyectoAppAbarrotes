package org.utl.ldsm406_puntoventa.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R

private data class BottomNavItem(
    val titleRes: Int,
    val icon: ImageVector
)

@Composable
fun BottonBar(
    selectedItem: Int,
    onItemSelected: (Int) -> Unit,
    onCerrarSesion: () -> Unit = {}
) {
    val naranja = colorResource(id = R.color.naranja_4)
    val cremaFondo = colorResource(id = R.color.crema_fondo)
    val cafeSuave = colorResource(id = R.color.cafe_4)

    val items = listOf(
        BottomNavItem(R.string.nav_home, Icons.Default.Home),
        BottomNavItem(R.string.nav_register, Icons.Default.AppRegistration),
        BottomNavItem(R.string.nav_products, Icons.Default.ShoppingCart),
        BottomNavItem(R.string.nav_suppliers, Icons.Default.Factory),
        BottomNavItem(R.string.nav_exit, Icons.AutoMirrored.Filled.ExitToApp)
    )

    val barraShape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 12.dp,
                shape = barraShape,
                ambientColor = Color.Black.copy(alpha = 0.10f),
                spotColor = Color.Black.copy(alpha = 0.10f)
            )
            .clip(barraShape),
        shape = barraShape,
        color = cremaFondo
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(68.dp)
                .navigationBarsPadding()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                val isSalir = index == items.lastIndex
                val isSelected = selectedItem == index
                val title = stringResource(id = item.titleRes)

                val pillBg by animateColorAsState(
                    targetValue = if (isSelected) naranja.copy(alpha = 0.14f) else Color.Transparent,
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                    label = "pillBg"
                )
                val iconTint by animateColorAsState(
                    targetValue = if (isSelected) naranja else cafeSuave,
                    animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
                    label = "iconTint"
                )

                val interactionSource = remember { MutableInteractionSource() }

                Row(
                    modifier = Modifier
                        .height(44.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(pillBg)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                if (isSalir) {
                                    onCerrarSesion()
                                } else {
                                    onItemSelected(index)
                                }
                            }
                        )
                        .padding(horizontal = if (isSelected) 12.dp else 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title,
                        tint = iconTint,
                        modifier = Modifier.size(22.dp)
                    )

                    AnimatedVisibility(
                        visible = isSelected,
                        enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
                        exit = fadeOut() + shrinkHorizontally(shrinkTowards = Alignment.Start)
                    ) {
                        Text(
                            text = title,
                            color = naranja,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            softWrap = false,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5EFE6)
@Composable
fun PreviewBottonBar() {
    BottonBar(selectedItem = 0, onItemSelected = {}, onCerrarSesion = {})
}