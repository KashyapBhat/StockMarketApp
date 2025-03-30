package kashyap.learning.stocktrading.stockmarket.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kashyap.learning.stocktrading.core.domain.onError
import kashyap.learning.stocktrading.core.domain.onSuccess
import kashyap.learning.stocktrading.core.presentation.toUiText
import kashyap.learning.stocktrading.stockmarket.domain.StockHomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class StocksHomeViewModel(
    private val stockHomeRepository: StockHomeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(StocksHomeState(arrayListOf()))
    val state = _state
        .onStart {
            val listOfStocks = listOf("AAPL", "HPQ")
            viewModelScope.launch {
                listOfStocks.map { symbol ->
                    launch { fetchStockInfo(symbol) }
                }.joinAll()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            _state.value
        )

    fun onAction(action: StocksHomeAction) {
        when (action) {
            is StocksHomeAction.OnStockClick -> {}
        }
    }

    private fun fetchStockInfo(symbol: String) {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            stockHomeRepository.getRecommendedAndFavoriteStocks(symbol)
                .onSuccess { stock ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            uiStocks = ArrayList(it.uiStocks).apply { add(stock) }
                        )
                    }
                }.onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }
}