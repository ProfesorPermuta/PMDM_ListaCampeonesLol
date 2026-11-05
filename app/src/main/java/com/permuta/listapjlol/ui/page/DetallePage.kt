package com.permuta.listapjlol.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.permuta.listapjlol.ui.componente.CampeonRelacionado
import com.permuta.listapjlol.ui.componente.CampeonRelacionadoData
import com.permuta.listapjlol.ui.componente.HabilidadItem
import com.permuta.listapjlol.ui.componente.HabilidadItemData
import com.permuta.listapjlol.ui.componente.ImagenCampeon
import com.permuta.listapjlol.ui.componente.ImagenCampeonData
import com.permuta.listapjlol.ui.componente.TituloSeccion
import com.permuta.listapjlol.ui.componente.TituloSeccionData
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme
import com.permuta.listapjlol.viewmodel.DetalleViewModel

@Composable
fun DetallePage(
    campeonId: String,
    onRelacionadoClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetalleViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val campeon = uiState.campeon

    // Se vuelve a lanzar si cambia el id del campeón a mostrar
    LaunchedEffect(campeonId) {
        viewModel.cargarCampeon(campeonId)
    }

    if (campeon == null) {
        Text("Campeón no encontrado", modifier = modifier.padding(16.dp))
        return
    }
    // Scroll de la pantalla completa
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ImagenCampeon(ImagenCampeonData(campeon.nombre, campeon.imagenGrande))
        Text(
            campeon.titulo,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        TituloSeccion(
            TituloSeccionData("Habilidades"),
            Modifier.padding(horizontal = 16.dp)
        )
        // Scroll propio de la lista: la altura máxima es obligatoria dentro de un
        // contenedor con scroll vertical (si no, restricciones infinitas y crash)
        LazyColumn(
            modifier = Modifier.heightIn(max = 300.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(campeon.habilidades, key = { it.tecla }) { h ->
                HabilidadItem(HabilidadItemData(h.tecla, h.nombre, h.descripcion))
            }
        }
        TituloSeccion(
            TituloSeccionData("Personajes relacionados"),
            Modifier.padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top
        ) {
            items(uiState.relacionados, key = { it.id }) { rel ->
                CampeonRelacionado(
                    data = CampeonRelacionadoData(rel.nombre, rel.imagenCard),
                    onClick = { onRelacionadoClick(rel.id) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetallePagePreview() {
    ListaPjLolTheme {
        DetallePage(campeonId = "Ahri", onRelacionadoClick = {})
    }
}
