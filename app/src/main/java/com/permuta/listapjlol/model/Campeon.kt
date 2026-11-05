package com.permuta.listapjlol.model

data class Habilidad(
    val tecla: String,
    val nombre: String,
    val descripcion: String
)

data class Campeon(
    val id: String,
    val nombre: String,
    val titulo: String,
    val habilidades: List<Habilidad>,
    val relacionados: List<String> // ids de otros campeones
) {
    val imagenCard: String
        get() = "https://ddragon.leagueoflegends.com/cdn/img/champion/loading/${id}_0.jpg"

    val imagenGrande: String
        get() = "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/${id}_0.jpg"
}
