package com.permuta.listapjlol.model

// Datos de ejemplo en memoria. Más adelante vivirán detrás de un repositorio / ViewModel.
val campeones = listOf(
    Campeon(
        id = "Ahri", nombre = "Ahri", titulo = "La zorra de nueve colas",
        habilidades = listOf(
            Habilidad("P", "Robo de esencia", "Tras derrotar a enemigos, Ahri recupera salud."),
            Habilidad("Q", "Orbe de engaño", "Lanza un orbe que va y vuelve infligiendo daño mágico."),
            Habilidad("W", "Fuego fatuo", "Libera tres llamas que persiguen a los enemigos cercanos."),
            Habilidad("E", "Encanto", "Lanza un beso que hechiza al primer enemigo alcanzado."),
            Habilidad("R", "Ímpetu espiritual", "Se lanza hacia delante hasta tres veces disparando a los enemigos.")
        ),
        relacionados = listOf("Lux", "Yasuo", "Zed")
    ),
    Campeon(
        id = "Garen", nombre = "Garen", titulo = "El poder de Demacia",
        habilidades = listOf(
            Habilidad("P", "Perseverancia", "Si no recibe daño durante un tiempo, regenera salud rápidamente."),
            Habilidad("Q", "Golpe decisivo", "Gana velocidad, y su siguiente ataque silencia y daña."),
            Habilidad("W", "Valor", "Reduce el daño recibido y protege contra el control."),
            Habilidad("E", "Juicio", "Gira su espada infligiendo daño a los enemigos cercanos."),
            Habilidad("R", "Justicia de Demacia", "Ejecuta a un campeón enemigo con poca salud.")
        ),
        relacionados = listOf("Darius", "Lux", "Ashe")
    ),
    Campeon(
        id = "Jinx", nombre = "Jinx", titulo = "El gatillo alegre",
        habilidades = listOf(
            Habilidad("P", "¡Qué emoción!", "Gana velocidad de movimiento y de ataque al participar en una eliminación."),
            Habilidad("Q", "¡Cambia-armas!", "Alterna entre su ametralladora y su lanzacohetes."),
            Habilidad("W", "¡Zap!", "Dispara una descarga que daña y ralentiza."),
            Habilidad("E", "¡Chispa-bombas!", "Lanza mordiscos explosivos que inmovilizan a los enemigos."),
            Habilidad("R", "¡Supercohete mega-mortífero!", "Dispara un cohete global que gana daño con la distancia.")
        ),
        relacionados = listOf("Ashe", "Teemo", "Thresh")
    ),
    Campeon(
        id = "Yasuo", nombre = "Yasuo", titulo = "El imperdonable",
        habilidades = listOf(
            Habilidad("P", "Camino del vagabundo", "Acumula energía al moverse que forma un escudo."),
            Habilidad("Q", "Acero tempestuoso", "Estoca hacia delante; al tercer golpe lanza un tornado."),
            Habilidad("W", "Muro de viento", "Crea un muro que bloquea los proyectiles enemigos."),
            Habilidad("E", "Barrido", "Se desliza a través de un enemigo infligiendo daño."),
            Habilidad("R", "Última respiración", "Teletransporta junto a un enemigo en el aire y lo golpea.")
        ),
        relacionados = listOf("Zed", "Ahri", "Darius")
    ),
    Campeon(
        id = "Lux", nombre = "Lux", titulo = "La dama luminosa",
        habilidades = listOf(
            Habilidad("P", "Iluminación", "Sus hechizos marcan al enemigo; su siguiente ataque detona la luz."),
            Habilidad("Q", "Ligadura de luz", "Lanza una esfera que inmoviliza hasta a dos enemigos."),
            Habilidad("W", "Barrera prismática", "Lanza su varita y protege con un escudo a los aliados."),
            Habilidad("E", "Singularidad lúcida", "Crea una zona de luz que ralentiza y luego explota."),
            Habilidad("R", "Chispa final", "Dispara un gran rayo de energía a gran distancia.")
        ),
        relacionados = listOf("Garen", "Ahri", "Ashe")
    ),
    Campeon(
        id = "Darius", nombre = "Darius", titulo = "La mano de Noxus",
        habilidades = listOf(
            Habilidad("P", "Hemorragia", "Sus ataques y habilidades hacen sangrar acumulativamente."),
            Habilidad("Q", "Decimar", "Gira su hacha; el filo exterior daña más y lo cura."),
            Habilidad("W", "Mutilación", "Su siguiente ataque inflige más daño y ralentiza."),
            Habilidad("E", "Aprehender", "Atrae a los enemigos hacia él con su hacha."),
            Habilidad("R", "Guillotina de Noxus", "Salta y ejecuta a un enemigo; más daño con más hemorragia.")
        ),
        relacionados = listOf("Garen", "Zed", "Thresh")
    ),
    Campeon(
        id = "Thresh", nombre = "Thresh", titulo = "El guardián de las cadenas",
        habilidades = listOf(
            Habilidad("P", "Condena", "Recoge almas de enemigos caídos para ganar armadura y poder."),
            Habilidad("Q", "Sentencia de muerte", "Lanza su cadena para atrapar y arrastrar a un enemigo."),
            Habilidad("W", "Farol oscuro", "Lanza un farol que permite a un aliado acercarse a Thresh."),
            Habilidad("E", "Flagelo", "Golpea con su cadena y empuja a los enemigos."),
            Habilidad("R", "La caja", "Levanta una caja de muros espectrales que ralentiza al cruzarla.")
        ),
        relacionados = listOf("Jinx", "Darius", "Lux")
    ),
    Campeon(
        id = "Teemo", nombre = "Teemo", titulo = "El explorador veloz",
        habilidades = listOf(
            Habilidad("P", "Sigilo", "Se vuelve invisible si permanece quieto un tiempo."),
            Habilidad("Q", "Ceguera", "Lanza un dardo que ciega al objetivo."),
            Habilidad("W", "Salto veloz", "Aumenta su velocidad de movimiento."),
            Habilidad("E", "Dardo tóxico", "Sus ataques envenenan; además, aplica veneno al golpear."),
            Habilidad("R", "Trampa nociva", "Coloca un hongo que explota y ralentiza al pisarlo.")
        ),
        relacionados = listOf("Jinx", "Ashe", "Garen")
    ),
    Campeon(
        id = "Zed", nombre = "Zed", titulo = "El maestro de las sombras",
        habilidades = listOf(
            Habilidad("P", "Desprecio por los débiles", "Daña extra a enemigos con poca salud."),
            Habilidad("Q", "Shuriken navaja", "Él y sus sombras lanzan shurikens que atraviesan enemigos."),
            Habilidad("W", "Sombra viviente", "Crea una sombra que puede intercambiar posición con él."),
            Habilidad("E", "Tajo sombrío", "Ataca en área con sus sombras y ralentiza."),
            Habilidad("R", "Marca de la muerte", "Se teletransporta a un campeón y detona daño acumulado.")
        ),
        relacionados = listOf("Yasuo", "Darius", "Ahri")
    ),
    Campeon(
        id = "Ashe", nombre = "Ashe", titulo = "La arquera de hielo",
        habilidades = listOf(
            Habilidad("P", "Foco de escarcha", "Sus ataques ralentizan y hacen más daño a los ralentizados."),
            Habilidad("Q", "Concentración del arquero", "Dispara ráfagas rápidas de flechas."),
            Habilidad("W", "Descarga de flechas", "Lanza una lluvia de flechas en cono."),
            Habilidad("E", "Halcón", "Envía un halcón que revela una zona lejana del mapa."),
            Habilidad("R", "Flecha de cristal encantada", "Lanza una flecha global que aturde al impactar.")
        ),
        relacionados = listOf("Lux", "Garen", "Jinx")
    )
)

fun campeonPorId(id: String): Campeon? = campeones.find { it.id == id }
