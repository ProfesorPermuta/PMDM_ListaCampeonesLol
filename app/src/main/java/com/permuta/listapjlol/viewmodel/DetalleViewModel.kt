package com.permuta.listapjlol.viewmodel

import androidx.lifecycle.ViewModel
import com.permuta.listapjlol.model.Campeon
import com.permuta.listapjlol.model.campeonPorId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class DetalleUiState(
    val campeon: Campeon? = null,
    val relacionados: List<Campeon> = emptyList()
)

class DetalleViewModel : ViewModel() {

    // Estado mutable: solo el ViewModel puede modificarlo
    private val _uiState = MutableStateFlow(DetalleUiState())

    // Versión de solo lectura que observa la página
    val uiState: StateFlow<DetalleUiState> = _uiState.asStateFlow()

    // El estado nace sin campeón; la página llamará a esto al iniciarse
    fun cargarCampeon(id: String) {
        val campeon = campeonPorId(id)
        _uiState.update {
            it.copy(
                campeon = campeon,
                relacionados = campeon?.relacionados.orEmpty().mapNotNull { rel -> campeonPorId(rel) }
            )
        }
    }
}
