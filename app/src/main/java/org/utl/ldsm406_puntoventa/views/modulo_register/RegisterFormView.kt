package org.utl.ldsm406_puntoventa.views.modulo_register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush.Companion.verticalGradient
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
    var errorResId by rememberSaveable { mutableStateOf<Int?>(null) }

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
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = CircleShape,
            color = colorResource(R.color.crema_1),
            shadowElevation = 4.dp,
            modifier = Modifier.size(64.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = null,
                    tint = colorResource(R.color.naranja_4),
                    modifier = Modifier.size(32.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.register_user_title),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = colorResource(R.color.crema_fondo),
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(R.color.crema_1)
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text(stringResource(id = R.string.field_full_name)) },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
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
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                OutlinedTextField(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = { Text(stringResource(id = R.string.field_username)) },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
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
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(id = R.string.field_password)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
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
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                OutlinedTextField(
                    value = passwordDos,
                    onValueChange = { passwordDos = it },
                    label = { Text(stringResource(id = R.string.field_confirm_password)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
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
                        focusedTextColor = colorResource(R.color.cafe_5),
                        unfocusedTextColor = colorResource(R.color.cafe_5)
                    )
                )

                errorResId?.let { resId ->
                    Text(
                        text = stringResource(id = resId),
                        color = MaterialTheme.colorScheme.error,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    onClick = {
                        val validationError = when {
                            nombre.isBlank() -> R.string.error_full_name_required
                            usuario.isBlank() -> R.string.error_username_required
                            password.isBlank() -> R.string.error_password_required
                            passwordDos.isBlank() -> R.string.error_confirm_password_required
                            password.trim() != passwordDos.trim() -> R.string.error_passwords_mismatch
                            else -> null
                        }
                        errorResId = validationError
                        if (validationError == null) {
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
                        contentColor = colorResource(R.color.crema_fondo)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Registrar", fontWeight = FontWeight.Bold)
                }

                OutlinedButton(
                    onClick = onCancelar,
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = colorResource(R.color.cafe_4)
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Cancelar", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}