package br.edu.unisep.stockcontrol.ui.liststock.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.edu.unisep.stockcontrol.data.entity.Stock
import br.edu.unisep.stockcontrol.dto.Stock.StockDto
import br.edu.unisep.stockcontrol.repository.StockRepository
import kotlinx.coroutines.launch

class ListStocksViewModel : ViewModel() {



    private val repository = StockRepository()

    val listStocks = MutableLiveData<List<StockDto>>()

    fun list() {
        viewModelScope.launch {
            val result = repository.findAll()
            listStocks.postValue(result)
        }



}
}