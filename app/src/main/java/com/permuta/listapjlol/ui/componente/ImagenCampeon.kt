package com.permuta.listapjlol.ui.componente

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

data class ImagenCampeonData(
    val nombre: String = "Ahri",
    val imagen: String = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ahri_0.jpg"
)

@Composable
fun ImagenCampeon(data: ImagenCampeonData, modifier: Modifier = Modifier) {
    AsyncImage(
        model = data.imagen,
        contentDescription = data.nombre,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun ImagenCampeonPreview() {
    ListaPjLolTheme { ImagenCampeon(ImagenCampeonData()) }
}
