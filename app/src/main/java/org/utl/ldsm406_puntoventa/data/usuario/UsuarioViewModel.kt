package org.utl.ldsm406_puntoventa.data.usuario

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.utl.ldsm406_puntoventa.data.AppDatabase

class UsuarioViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val dao = AppDatabase
        .obtenerInstancia(application)
        .usuarioDao()

    private val repository = UsuarioRepository(dao)

    fun guardar(usuario: Usuario, alGuardar: () -> Unit = {}) {
        viewModelScope.launch {
            repository.insertar(usuario)
            alGuardar()
        }
    }

    fun validarLogin(usuario: String, pass: String, onResultado: (Usuario?) -> Unit) {
        viewModelScope.launch {
            val usuarioEncontrado = repository.iniciarSesion(usuario, pass)
            onResultado(usuarioEncontrado)
        }
    }
}