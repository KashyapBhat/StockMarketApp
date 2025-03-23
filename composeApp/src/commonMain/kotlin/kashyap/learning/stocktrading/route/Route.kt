package kashyap.learning.stocktrading.route
import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object StockAppGraph: Route

    @Serializable
    data object HomePage: Route

    @Serializable
    data class StockPage(val id: String): Route
}