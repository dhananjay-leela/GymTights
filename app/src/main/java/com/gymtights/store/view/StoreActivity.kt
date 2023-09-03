package com.gymtights.store.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gymtights.store.view.ui.ProductsViewModel
import com.gymtights.store.view.ui.screens.ProductInfoScreen
import com.gymtights.store.view.ui.screens.ProductsListScreen
import com.gymtights.store.view.ui.theme.GymTightsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<ProductsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymTightsTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
////                    Toast.makeText(LocalContext.current, viewModel.errorMessage.value, Toast.LENGTH_SHORT).show()
//                }
                NavGraph(viewModel)

            }
        }
    }
}

@Composable
fun NavGraph(viewModel: ProductsViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = "productsListScreen"
    ) {
        composable("productsListScreen") {
            ProductsListScreen(viewModel = viewModel)
        }
        composable("productInfoScreen") {
            ProductInfoScreen(product = emptyList()) { }
        }
    }
}