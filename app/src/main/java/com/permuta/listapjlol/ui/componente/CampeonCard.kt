package com.permuta.listapjlol.ui.componente

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
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

data class CampeonCardData(
    val nombre: String = "Ahri",
    val titulo: String = "La zorra de nueve colas",
    val imagen: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/Ahri_0.jpg"
)

@Composable
fun CampeonCard(
    data: CampeonCardData,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
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
            Column {
                Text(data.nombre, style = MaterialTheme.typography.titleMedium)
                Text(data.titulo, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CampeonCardPreview() {
    ListaPjLolTheme { CampeonCard(CampeonCardData(), onClick = {}) }
}
