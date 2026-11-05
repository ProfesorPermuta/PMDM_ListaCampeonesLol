package com.permuta.listapjlol.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.listapjlol.ui.componente.BuscadorCampeon
import com.permuta.listapjlol.ui.componente.BuscadorCampeonData
import com.permuta.listapjlol.ui.componente.CampeonCard
import com.permuta.listapjlol.ui.componente.CampeonCardData
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme
import com.permuta.listapjlol.viewmodel.ListaViewModel

@Composable
fun ListaPage(
    onCampeonClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ListaViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // Al entrar en la página se pide al ViewModel que cargue el listado
    LaunchedEffect(Unit) {
        viewModel.cargarCampeones()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BuscadorCampeon(
            data = BuscadorCampeonData(texto = uiState.filtro),
            onTextoChange = viewModel::onFiltroChange,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(uiState.campeones, key = { it.id }) { campeon ->
                CampeonCard(
                    data = CampeonCardData(campeon.nombre, campeon.titulo, campeon.imagenCard),
                    onClick = { onCampeonClick(campeon.id) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListaPagePreview() {
    ListaPjLolTheme { ListaPage(onCampeonClick = {}) }
}
