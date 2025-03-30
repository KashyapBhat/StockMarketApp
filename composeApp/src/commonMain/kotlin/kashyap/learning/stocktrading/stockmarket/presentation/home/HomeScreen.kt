package kashyap.learning.stocktrading.stockmarket.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.GraphContent
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.HomeTitleContent
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.RecommendedStocks
import kashyap.learning.stocktrading.stockmarket.presentation.home.components.WatchListStocks
import org.koin.compose.viewmodel.koinViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreenRoot(viewModel: StocksHomeViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreen(state)
}

@Composable
fun HomeScreen(
    state: StocksHomeState,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            HomeTitleContent()
            GraphContent()
            RecommendedStocks(state.recommendedStocks)
            WatchListStocks(state.watchlistStocks)
        }
    }
}