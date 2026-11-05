package com.permuta.listapjlol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.permuta.listapjlol.model.campeonPorId
import com.permuta.listapjlol.ui.page.DetallePage
import com.permuta.listapjlol.ui.page.ListaPage
import com.permuta.listapjlol.ui.theme.ListaPjLolTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaPjLolTheme {
                val navController = rememberNavController()
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val entry by navController.currentBackStackEntryAsState()
                val enDetalle = entry?.destination?.route == "detalle/{id}"
                val titulo = if (enDetalle) {
                    campeonPorId(entry?.arguments?.getString("id").orEmpty())?.nombre ?: "Detalle"
                } else {
                    "Campeones"
                }

                // Único Scaffold de la app: las páginas solo aportan su contenido
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = true,
                                onClick = {
                                    // Vuelve al listado, descartando los detalles apilados
                                    navController.navigate("lista") {
                                        popUpTo("lista") { inclusive = true }
                                        launchSingleTop = true
                                    }
                                },
                                icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                                label = { Text("Inicio") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {
                                    scope.launch {
                                        snackbarHostState.currentSnackbarData?.dismiss()
                                        snackbarHostState.showSnackbar("La página de configuración aún no existe")
                                    }
                                },
                                icon = { Icon(Icons.Filled.Settings, contentDescription = null) },
                                label = { Text("Configuración") }
                            )
                        }
                    },
                    topBar = {
                        TopAppBar(
                            title = { Text(titulo) },
                            navigationIcon = {
                                if (enDetalle) {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Volver"
                                        )
                                    }
                                }
                            }
                        )
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "lista",
                        modifier = Modifier.padding(padding)
                    ) {
                        composable("lista") {
                            ListaPage(onCampeonClick = { navController.navigate("detalle/$it") })
                        }
                        composable(
                            route = "detalle/{id}",
                            arguments = listOf(navArgument("id") { type = NavType.StringType })
                        ) { backStackEntry ->
                            DetallePage(
                                campeonId = backStackEntry.arguments?.getString("id").orEmpty(),
                                onRelacionadoClick = { navController.navigate("detalle/$it") }
                            )
                        }
                    }
                }
            }
        }
    }
}
