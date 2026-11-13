package org.utl.ldsm406_puntoventa.views


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.utl.ldsm406_puntoventa.R

@Composable
fun LogginView(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password = rememberTextFieldState()


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
        Text(
            "Punto de Venta",
            color = colorResource(R.color.white),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier
                .padding(20.dp) //Funciona como margin
                .background(
                    colorResource(R.color.azul_1),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp) //Funciona como padding
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = {
                    Text("Ingresa tu usuario")
                },
                modifier = Modifier.fillMaxWidth(),
                colors = colors(
                    colorResource(R.color.white),
                    colorResource(R.color.azul_2),
                    colorResource(R.color.azul_1),
                    colorResource(R.color.black),
                    colorResource(R.color.azul_1),
                    colorResource(R.color.azul_1),
                    focusedLabelColor = colorResource(R.color.white),
                    unfocusedLabelColor = colorResource(R.color.black)
                )
            )

            Spacer(modifier = Modifier.height(26.dp))

            OutlinedSecureTextField(
                state = password,
                label = {
                    Text("Ingresa tu contraseña")
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    onLoginSuccess()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = buttonColors(
                    colorResource(R.color.azul_5),
                    colorResource(R.color.azul_4)
                )
            ) {
                Text("Ingresar", color = Color.White)
            }

            Button(
                onClick = {
                    onRegisterClick()
                },
                modifier = Modifier.fillMaxWidth(),
                colors = buttonColors(
                    colorResource(R.color.azul_5),
                    colorResource(R.color.azul_4)
                )
            ) {
                Text("Registrarse", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PreviewLogginView() {
    LogginView({}, onRegisterClick = {})
}