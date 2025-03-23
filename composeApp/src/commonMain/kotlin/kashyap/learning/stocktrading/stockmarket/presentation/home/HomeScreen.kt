package kashyap.learning.stocktrading.stockmarket.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.GraphContent
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.HomeTitleContent
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.RecommendedStocks
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.WatchListStocks

@Composable
fun HomeScreenRoot() {
    HomeScreen()
}

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HomeTitleContent()
            GraphContent()
            RecommendedStocks()
            WatchListStocks()
        }
    }
}