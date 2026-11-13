package org.utl.ldsm406_puntoventa.views.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.utl.ldsm406_puntoventa.data.usuario.UsuarioViewModel
import org.utl.ldsm406_puntoventa.views.HomeView
import org.utl.ldsm406_puntoventa.views.LogginView
import org.utl.ldsm406_puntoventa.views.modulo_register.RegisterFormView

@Composable
fun AppNavegation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Login"
    ){
        composable ( route = "Login" ){
            LogginView(
                onLoginSuccess = {
                    navController.navigate(route = "Home")
                },
                onRegisterClick = {
                    navController.navigate(route = "FormRegister")
                }
            )
        }
        composable(route = "FormRegister") {
            val viewModel: UsuarioViewModel = viewModel()

            RegisterFormView(
                onGuardar = { usuario ->
                    viewModel.guardar(usuario) {
                        navController.popBackStack()
                    }
                },
                onCancelar = {
                    navController.popBackStack()
                }
            )
        }
        composable ( route = "Home" ){
            HomeView()
        }
    }
}