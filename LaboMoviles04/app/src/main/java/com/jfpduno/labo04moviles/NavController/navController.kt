package com.jfpduno.labo04moviles.NavController

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jfpduno.labo04moviles.ViewModel.GeneralViewModel
import com.jfpduno.labo04moviles.ui.Screens.Pantalla2
import com.jfpduno.labo04moviles.ui.Screens.PantallaPrincipal


class navController {

    @Composable
    fun NavController() {
        val navController = rememberNavController()

        val viewModel: GeneralViewModel = viewModel()

        NavHost(
            navController = navController,
            startDestination = "PantallaPrincipal"
        ) {

            composable("PantallaPrincipal") {
                PantallaPrincipal(
                    navController = navController,
                    viewModel = viewModel
                )
            }

            composable("Pantalla2") {
                Pantalla2(
                    navController = navController,
                    viewModel = viewModel
                )
            }
        }
    }
}


