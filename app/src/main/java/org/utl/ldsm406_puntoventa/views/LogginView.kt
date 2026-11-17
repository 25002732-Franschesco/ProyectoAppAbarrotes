package org.utl.ldsm406_puntoventa.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.utl.ldsm406_puntoventa.R
import org.utl.ldsm406_puntoventa.data.usuario.UsuarioViewModel

@Composable
fun LogginView(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit,
    usuarioViewModel: UsuarioViewModel = viewModel()
) {
    var username by remember { mutableStateOf("") }
    val passwordState = rememberTextFieldState()
    var errorMsg by remember { mutableStateOf("") }

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
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = CircleShape,
            color = colorResource(R.color.crema_1),
            shadowElevation = 6.dp,
            modifier = Modifier.size(80.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Storefront,
                    contentDescription = "Logo Tienda",
                    tint = colorResource(R.color.naranja_4),
                    modifier = Modifier.size(44.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tiendita",
            color = colorResource(R.color.crema_fondo),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Lleva un Registro",
            color = colorResource(R.color.crema_2),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.crema_1)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Iniciar Sesión",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.cafe_5)
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Usuario") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = colorResource(R.color.naranja_4)
                        )
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.naranja_4),
                        unfocusedBorderColor = colorResource(R.color.crema_3),
                        focusedLabelColor = colorResource(R.color.naranja_4),
                        unfocusedLabelColor = colorResource(R.color.cafe_4),
                        cursorColor = colorResource(R.color.naranja_4),
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                OutlinedSecureTextField(
                    state = passwordState,
                    label = { Text("Contraseña") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            tint = colorResource(R.color.naranja_4)
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = colorResource(R.color.naranja_4),
                        unfocusedBorderColor = colorResource(R.color.crema_3),
                        focusedLabelColor = colorResource(R.color.naranja_4),
                        unfocusedLabelColor = colorResource(R.color.cafe_4),
                        cursorColor = colorResource(R.color.naranja_4),
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                if (errorMsg.isNotBlank()) {
                    Text(
                        text = errorMsg,
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    onClick = {
                        val passText = passwordState.text.toString()
                        if (username.isBlank() || passText.isBlank()) {
                            errorMsg = "Llena todos los campos"
                        } else {
                            usuarioViewModel.validarLogin(username.trim(), passText.trim()) { usuarioEncontrado ->
                                if (usuarioEncontrado != null) {
                                    onLoginSuccess()
                                } else {
                                    errorMsg = "Usuario o contraseña incorrectos"
                                }
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.naranja_4),
                        contentColor = colorResource(R.color.crema_fondo)
                    )
                ) {
                    Text(
                        text = "Ingresar",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = { onRegisterClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.5.dp, colorResource(R.color.verde_4)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorResource(R.color.verde_4)
                    )
                ) {
                    Text(
                        text = "Crear cuenta nueva",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}