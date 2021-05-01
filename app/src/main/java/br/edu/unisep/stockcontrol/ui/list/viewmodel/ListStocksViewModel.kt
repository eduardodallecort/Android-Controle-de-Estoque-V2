package br.edu.unisep.stockcontrol.ui.list.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.unisep.stockcontrol.data.entity.Stock

class ListStocksViewModel : ViewModel() {

    private val allStocks = mutableListOf<Stock>()

    val stocks = MutableLiveData<List<Stock>>()

    fun add(stock: Stock) {
        allStocks.add(stock)
        stocks.postValue(allStocks)
    }

    fun remove(position: Int) {
        allStocks.removeAt(position)
        stocks.postValue(allStocks)
    }

}