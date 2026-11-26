package org.utl.ldsm406_puntoventa.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R

data class CategoriaProducto(
    val nombre: String,
    val icono: ImageVector
)

val categoriasTienda = listOf(
    CategoriaProducto("Bebidas", Icons.Rounded.LocalDrink),
    CategoriaProducto("Botanas y Dulces", Icons.Rounded.Cookie),
    CategoriaProducto("Lácteos", Icons.Rounded.EggAlt),
    CategoriaProducto("Abarrotes", Icons.Rounded.Inventory2),
    CategoriaProducto("Panadería", Icons.Rounded.BakeryDining),
    CategoriaProducto("Frutas y Verduras", Icons.Rounded.Eco),
    CategoriaProducto("Carnes y Embutidos", Icons.Rounded.SetMeal),
    CategoriaProducto("Limpieza", Icons.Rounded.CleaningServices),
    CategoriaProducto("Cuidado Personal", Icons.Rounded.Sanitizer),
    CategoriaProducto("Congelados", Icons.Rounded.AcUnit),
    CategoriaProducto("Mascotas", Icons.Rounded.Pets),
    CategoriaProducto("Varios", Icons.Rounded.Category)
)

@Composable
fun CategoriaSelector(
    categoriaSeleccionada: String,
    onCategoriaSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val naranja = colorResource(id = R.color.naranja_4)
    val cremaFondo = colorResource(id = R.color.crema_fondo)
    val cafeOscuro = colorResource(id = R.color.cafe_5)
    val cafeSuave = colorResource(id = R.color.cafe_4)

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Categoría",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = cafeOscuro
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 2.dp)
        ) {
            items(categoriasTienda, key = { it.nombre }) { categoria ->
                val seleccionada = categoriaSeleccionada == categoria.nombre

                Surface(
                    onClick = { onCategoriaSelected(categoria.nombre) },
                    shape = RoundedCornerShape(16.dp),
                    color = if (seleccionada) naranja else cremaFondo,
                    border = BorderStroke(
                        width = 1.dp,
                        color = if (seleccionada) naranja else cafeSuave.copy(alpha = 0.25f)
                    ),
                    tonalElevation = 0.dp
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = categoria.icono,
                            contentDescription = categoria.nombre,
                            tint = if (seleccionada) Color.White else naranja,
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = categoria.nombre,
                            fontSize = 13.sp,
                            fontWeight = if (seleccionada) FontWeight.Bold else FontWeight.Medium,
                            color = if (seleccionada) Color.White else cafeOscuro
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoriaSelector() {
    CategoriaSelector(
        categoriaSeleccionada = "Bebidas",
        onCategoriaSelected = {}
    )
}