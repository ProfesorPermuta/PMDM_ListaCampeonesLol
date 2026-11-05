package com.permuta.listapjlol.viewmodel

import androidx.lifecycle.ViewModel
import com.permuta.listapjlol.model.Campeon
import com.permuta.listapjlol.model.campeones as todosLosCampeones
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ListaUiState(
    val filtro: String = "",
    val campeones: List<Campeon> = emptyList()
)

class ListaViewModel : ViewModel() {

    // Estado mutable: solo el ViewModel puede modificarlo
    private val _uiState = MutableStateFlow(ListaUiState())

    // Versión de solo lectura que observa la página
    val uiState: StateFlow<ListaUiState> = _uiState.asStateFlow()

    // El estado nace con la lista vacía; la página llamará a esto al iniciarse
    fun cargarCampeones() {
        _uiState.update { it.copy(campeones = todosLosCampeones) }
    }

    fun onFiltroChange(filtro: String) {
        _uiState.update {
            it.copy(
                filtro = filtro,
                campeones = todosLosCampeones.filter { c -> c.nombre.contains(filtro, ignoreCase = true) }
            )
        }
    }
}
