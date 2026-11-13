package org.utl.ldsm406_puntoventa.views.modulo_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.TextFieldDefaults.colors
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.producto.Producto
import org.utl.ldsm406_puntoventa.data.usuario.Usuario
import org.utl.ldsm406_puntoventa.views.modulo_producto.ProductoFormView
import org.utl.ldsm406_puntoventa.views.navigation.InicioView

@Composable
fun RegisterFormView(
    onGuardar: (Usuario) -> Unit,
    onCancelar: () -> Unit
) {
    var nombre by rememberSaveable() { mutableStateOf("") }
    var usuario by rememberSaveable() { mutableStateOf("") }
    var password by rememberSaveable() { mutableStateOf("") }
    var password_dos by rememberSaveable() { mutableStateOf("") }
    var error by rememberSaveable() { mutableStateOf("") }


    Column(
        modifier = Modifier.background(
            brush = verticalGradient(
                colors = listOf(
                    colorResource(R.color.azul_5),
                    colorResource(R.color.azul_3)
                )
            )
        )
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(all = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                "Registro de tu nuevo usuario",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre: ",
                    color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = colors(colorResource(R.color.black))
            )

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Nombre de usuario: ",
                    color = Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = colors(colorResource(R.color.black))
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña: ",
                    color = Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = colors(colorResource(R.color.black))
            )

            OutlinedTextField(
                value = password_dos,
                onValueChange = { password_dos = it },
                label = { Text("Vuelve a ingresar la contraseña: ",
                    color = Color.Black,) },
                modifier = Modifier.fillMaxWidth(),
                colors = colors(colorResource(R.color.black))
            )

            if (error.isNotBlank()) {
                Text(
                    error,
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }

            Button(
                onClick = {
                    error = when {
                        nombre.isBlank() -> "Mete tu nombre de usuario"
                        password.isBlank() -> "Introduce tu contraseña"
                        password_dos.isBlank() -> "Introduce tu contraseña"
                        else -> ""
                    }
                    if (error.isBlank()) {
                        if (password.trim() == password_dos.trim()) {
                            onGuardar(
                                Usuario(
                                    id = 0,
                                    nombre = nombre.trim(),
                                    usuario = usuario.trim(),
                                    password = password.trim()
                                )
                            )
                        } else {
                            error = "Las contraseñas tienen que ser las mismas"
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(10.dp, 20.dp)
            ) {
                Text("Registrar")
            }
        }
    }
}
