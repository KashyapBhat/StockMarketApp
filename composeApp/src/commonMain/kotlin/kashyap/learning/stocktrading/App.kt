package kashyap.learning.stocktrading

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import kashyap.learning.stocktrading.core.presentation.AppColor
import kashyap.learning.stocktrading.route.Route
import kashyap.learning.stocktrading.stockmarket.presentation.home.HomeScreenRoot
import kashyap.learning.stocktrading.stockmarket.presentation.stockdetails.StockDetailsScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(colors = AppColor) {
        val navController = rememberNavController()
        NavHost(
            modifier = Modifier.fillMaxSize().safeDrawingPadding(),
            navController = navController,
            startDestination = Route.StockAppGraph
        ) {
            navigation<Route.StockAppGraph>(
                startDestination = Route.HomePage
            ) {
                composable<Route.HomePage>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    HomeScreenRoot()
                }
                composable<Route.StockPage>(
                    enterTransition = { slideInHorizontally { initialOffset ->
                        initialOffset
                    } },
                    exitTransition = { slideOutHorizontally { initialOffset ->
                        initialOffset
                    } }
                ) {
                    StockDetailsScreenRoot()
                }
            }
        }
    }
}