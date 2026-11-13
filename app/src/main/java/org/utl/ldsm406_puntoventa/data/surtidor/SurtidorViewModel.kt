package org.utl.ldsm406_puntoventa.data.surtidor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.utl.ldsm406_puntoventa.data.AppDatabase

class SurtidorViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val dao = AppDatabase
        .obtenerInstancia(application)
        .surtidorDao()

    private val repository = SurtidorRepository(dao)

    val listaSurtidores: StateFlow<List<Surtidor>> = repository.obtenerSurtidores
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun guardar(surtidor: Surtidor, alGuardar: () -> Unit) {
        viewModelScope.launch {
            if (surtidor.id == 0) {
                repository.insertar(surtidor)
            } else {
                repository.actualizar(surtidor)
            }
            alGuardar()
        }
    }

    fun eliminar(surtidor: Surtidor) {
        viewModelScope.launch {
            repository.eliminar(surtidor)
        }
    }
}