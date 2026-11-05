package com.permuta.listapjlol.ui.componente

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

data class BuscadorCampeonData(
    val texto: String = "",
    val placeholder: String = "Buscar campeón por nombre"
)

@Composable
fun BuscadorCampeon(
    data: BuscadorCampeonData,
    onTextoChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = data.texto,
        onValueChange = onTextoChange,
        placeholder = { Text(data.placeholder) },
        singleLine = true,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
private fun BuscadorCampeonPreview() {
    ListaPjLolTheme { BuscadorCampeon(BuscadorCampeonData(), onTextoChange = {}) }
}
