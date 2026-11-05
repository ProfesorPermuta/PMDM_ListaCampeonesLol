package com.permuta.listapjlol.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.permuta.listapjlol.model.campeones
import com.permuta.listapjlol.ui.componente.BuscadorCampeon
import com.permuta.listapjlol.ui.componente.BuscadorCampeonData
import com.permuta.listapjlol.ui.componente.CampeonCard
import com.permuta.listapjlol.ui.componente.CampeonCardData
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

@Composable
fun ListaPage(onCampeonClick: (String) -> Unit, modifier: Modifier = Modifier) {
    // Estado local de la página: es lo que se moverá al ViewModel
    var filtro by remember { mutableStateOf("") }
    val filtrados = campeones.filter { it.nombre.contains(filtro, ignoreCase = true) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        BuscadorCampeon(
            data = BuscadorCampeonData(texto = filtro),
            onTextoChange = { filtro = it },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filtrados, key = { it.id }) { campeon ->
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
