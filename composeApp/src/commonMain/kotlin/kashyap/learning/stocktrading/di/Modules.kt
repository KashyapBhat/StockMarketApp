package kashyap.learning.stocktrading.di

import kashyap.learning.stocktrading.core.data.HttpClientFactory
import kashyap.learning.stocktrading.stockmarket.data.clients.FinHubAPIClient
import kashyap.learning.stocktrading.stockmarket.data.network.KtorRemoteStocksHomeDataSource
import kashyap.learning.stocktrading.stockmarket.data.network.RemoteStocksHomeDataSource
import kashyap.learning.stocktrading.stockmarket.data.repository.DefaultStocksHomeRepository
import kashyap.learning.stocktrading.stockmarket.domain.StockHomeRepository
import kashyap.learning.stocktrading.stockmarket.presentation.home.StocksHomeViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    single { FinHubAPIClient(get()) }
    singleOf(::KtorRemoteStocksHomeDataSource).bind<RemoteStocksHomeDataSource>()
    singleOf(::DefaultStocksHomeRepository).bind<StockHomeRepository>()
}


val viewModels = module {
    viewModelOf(::StocksHomeViewModel)
}
