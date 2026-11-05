package com.permuta.listapjlol.ui.componente

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

data class CampeonRelacionadoData(
    val nombre: String = "Lux",
    val imagen: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/Lux_0.jpg"
)

@Composable
fun CampeonRelacionado(
    data: CampeonRelacionadoData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(80.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        AsyncImage(
            model = data.imagen,
            contentDescription = data.nombre,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
        )
        Text(data.nombre, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview(showBackground = true)
@Composable
private fun CampeonRelacionadoPreview() {
    ListaPjLolTheme { CampeonRelacionado(CampeonRelacionadoData(), onClick = {}) }
}
