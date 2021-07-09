package br.edu.unisep.stockcontrol.di

import br.edu.unisep.stockcontrol.domain.dto.repository.ItemRepository
import br.edu.unisep.stockcontrol.domain.dto.repository.StockRepository
import br.edu.unisep.stockcontrol.ui.editstockproduct.EditStockProductViewModel
import br.edu.unisep.stockcontrol.ui.liststock.ListStocksViewModel
import br.edu.unisep.stockcontrol.ui.liststockproduct.ListStockProductsViewModel
import br.edu.unisep.stockcontrol.ui.registerstock.RegisterStockViewModel
import br.edu.unisep.stockcontrol.ui.registerstrockproduct.RegisterStockProductActivity
import br.edu.unisep.stockcontrol.ui.registerstrockproduct.RegisterStockProductActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel { EditStockProductViewModel(get()) }
    viewModel { ListStocksViewModel(get()) }
    viewModel { ListStockProductsViewModel(get()) }
    viewModel { RegisterStockViewModel(get()) }
    viewModel { RegisterStockProductActivityViewModel(get()) }
}

val repositoryModule = module {
    single { ItemRepository() }
    single { StockRepository() }
}