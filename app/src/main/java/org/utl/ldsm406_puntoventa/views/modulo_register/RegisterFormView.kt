package org.utl.ldsm406_puntoventa.views.modulo_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.usuario.Usuario

@Composable
fun RegisterFormView(
    onGuardar: (Usuario) -> Unit,
    onCancelar: () -> Unit
) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var usuario by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordDos by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = verticalGradient(
                    colors = listOf(
                        colorResource(R.color.naranja_5),
                        colorResource(R.color.naranja_3)
                    )
                )
            )
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro de tu nuevo usuario",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = colorResource(R.color.white),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.crema_1),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre completo") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(R.color.naranja_4),
                    unfocusedBorderColor = colorResource(R.color.crema_3),
                    focusedLabelColor = colorResource(R.color.naranja_4),
                    unfocusedLabelColor = colorResource(R.color.cafe_4)
                )
            )

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Nombre de usuario") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(R.color.naranja_4),
                    unfocusedBorderColor = colorResource(R.color.crema_3),
                    focusedLabelColor = colorResource(R.color.naranja_4),
                    unfocusedLabelColor = colorResource(R.color.cafe_4)
                )
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(R.color.naranja_4),
                    unfocusedBorderColor = colorResource(R.color.crema_3),
                    focusedLabelColor = colorResource(R.color.naranja_4),
                    unfocusedLabelColor = colorResource(R.color.cafe_4)
                )
            )

            OutlinedTextField(
                value = passwordDos,
                onValueChange = { passwordDos = it },
                label = { Text("Vuelve a ingresar la contraseña") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = colorResource(R.color.naranja_4),
                    unfocusedBorderColor = colorResource(R.color.crema_3),
                    focusedLabelColor = colorResource(R.color.naranja_4),
                    unfocusedLabelColor = colorResource(R.color.cafe_4)
                )
            )

            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = {
                    error = when {
                        nombre.isBlank() -> "Ingresa tu nombre completo"
                        usuario.isBlank() -> "Ingresa un nombre de usuario"
                        password.isBlank() -> "Introduce tu contraseña"
                        passwordDos.isBlank() -> "Confirma tu contraseña"
                        password.trim() != passwordDos.trim() -> "Las contraseñas tienen que ser iguales"
                        else -> ""
                    }
                    if (error.isBlank()) {
                        onGuardar(
                            Usuario(
                                id = 0,
                                nombre = nombre.trim(),
                                usuario = usuario.trim(),
                                password = password.trim()
                            )
                        )
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.naranja_4),
                    contentColor = colorResource(R.color.white)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrar")
            }

            OutlinedButton(
                onClick = onCancelar,
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = colorResource(R.color.cafe_4)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar")
            }
        }
    }
}