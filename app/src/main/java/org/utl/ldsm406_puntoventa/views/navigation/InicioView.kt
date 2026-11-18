package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AppRegistration
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R

@Composable
fun InicioView(
    onItemSelected: (Int) -> Unit = {},
    onCerrarSesion: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.crema_1))
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 16.dp,
                    shape = RoundedCornerShape(28.dp),
                    ambientColor = colorResource(id = R.color.naranja_5).copy(alpha = 0.25f),
                    spotColor = colorResource(id = R.color.naranja_5).copy(alpha = 0.25f)
                )
                .clip(RoundedCornerShape(28.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(id = R.color.naranja_5),
                            colorResource(id = R.color.naranja_4),
                            colorResource(id = R.color.naranja_3)
                        )
                    )
                )
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = 40.dp, y = (-40).dp)
                    .background(Color.White.copy(alpha = 0.12f), shape = CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = (-10).dp, y = 30.dp)
                    .background(Color.White.copy(alpha = 0.08f), shape = CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(26.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White.copy(alpha = 0.2f),
                    modifier = Modifier.padding(bottom = 14.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Storefront,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = "TIENDA LILI",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp,
                            color = Color.White
                        )
                    }
                }

                Text(
                    text = "¡Bienvenido Crack!",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = (-0.5).sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Gestiona tu tiendita muy rápido y sencillo.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Accesos Rápidos",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-0.3).sp,
                    color = colorResource(id = R.color.cafe_5)
                )
                Text(
                    text = "4 Opciones",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.cafe_4)
                )
            }

            MenuCard(
                titulo = "Catálogo de Productos",
                descripcion = "Consulta precios, stock y gestiona artículos",
                icono = Icons.Default.ShoppingCart,
                accentColor = colorResource(id = R.color.naranja_4), // Naranja
                onClick = { onItemSelected(2) }
            )

            MenuCard(
                titulo = "Catálogo de Surtidores",
                descripcion = "Administra proveedores y contactos",
                icono = Icons.Default.Factory,
                accentColor = colorResource(id = R.color.verde_4), // Verde
                onClick = { onItemSelected(3) }
            )

            MenuCard(
                titulo = "Panel de Registros",
                descripcion = "Altas rápidas de inventario y surtidores",
                icono = Icons.Default.AppRegistration,
                accentColor = Color(0xFF3B82F6), // Azul moderno
                onClick = { onItemSelected(1) }
            )

            MenuCard(
                titulo = "Cerrar Sesión",
                descripcion = "Salir de tu cuenta actual de forma segura",
                icono = Icons.AutoMirrored.Filled.ExitToApp,
                accentColor = Color(0xFFD97706), // Ámbar / Mostaza
                onClick = onCerrarSesion
            )
        }
    }
}

@Composable
fun MenuCard(
    titulo: String,
    descripcion: String,
    icono: ImageVector,
    accentColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(22.dp),
                ambientColor = Color.Black.copy(alpha = 0.04f),
                spotColor = Color.Black.copy(alpha = 0.04f)
            ),
        shape = RoundedCornerShape(22.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.crema_fondo)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(accentColor.copy(alpha = 0.14f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icono,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(26.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.cafe_5)
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = descripcion,
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    color = colorResource(id = R.color.cafe_4)
                )
            }

            Surface(
                shape = CircleShape,
                color = colorResource(id = R.color.crema_2),
                modifier = Modifier.size(32.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                        tint = colorResource(id = R.color.cafe_4),
                        modifier = Modifier.size(13.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInicio() {
    InicioView()
}