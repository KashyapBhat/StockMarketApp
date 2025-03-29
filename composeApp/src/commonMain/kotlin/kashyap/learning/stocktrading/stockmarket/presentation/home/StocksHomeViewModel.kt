package kashyap.learning.stocktrading.stockmarket.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kashyap.learning.stocktrading.core.domain.onError
import kashyap.learning.stocktrading.core.domain.onSuccess
import kashyap.learning.stocktrading.core.presentation.toUiText
import kashyap.learning.stocktrading.stockmarket.domain.StockHomeRepository
import kashyap.learning.stocktrading.stockmarket.domain.StockInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StocksHomeViewModel(
    private val stockHomeRepository: StockHomeRepository
) : ViewModel() {

    private var stocksInfo = arrayListOf<StockInfo>()

    private val _state = MutableStateFlow(StocksHomeState(stocksInfo))
    val state = _state
        .onStart {
            if (stocksInfo.isEmpty()) {
                fetchStockInfo()
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

    private fun fetchStockInfo() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            stockHomeRepository.getRecommendedAndFavoriteStocks(symbol = "")
                .onSuccess { stocks ->
                    stocksInfo.add(stocks)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = null,
                            uiStocks = stocksInfo
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            uiStocks = stocksInfo,
                            isLoading = false,
                            errorMessage = error.toUiText()
                        )
                    }
                }
        }
    }

}