package com.permuta.listapjlol.ui.componente

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

data class TituloSeccionData(
    val texto: String = "Habilidades"
)

@Composable
fun TituloSeccion(data: TituloSeccionData, modifier: Modifier = Modifier) {
    Text(data.texto, style = MaterialTheme.typography.titleLarge, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
private fun TituloSeccionPreview() {
    ListaPjLolTheme { TituloSeccion(TituloSeccionData()) }
}
